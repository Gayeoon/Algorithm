package Naming_7396;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Name {
	int row, col;
	char st;

	Name(int row, int col, char st) {
		this.row = row;
		this.col = col;
		this.st = st;
	}
}

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. �������� �ۼ��� �ڵ带
		 * �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ ��
		 * ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		 * ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */
		String answer[] = new String[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] arr = new char[n][m];
			boolean[][] visit = new boolean[n][m];
			int Dr[] = { 1, 0 };
			int Dc[] = { 0, 1 };

			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			Queue<Name> queue = new LinkedList<Name>();
			queue.add(new Name(0, 0, arr[0][0]));
			char name[] = new char[n + m - 1];
			name[0] = arr[0][0];
			visit[0][0] = true;
			for (int i = 0; i < n + m - 1; i++) {
				Queue<Name> q = new LinkedList<Name>();
				name[i] = queue.peek().st;
				while (!queue.isEmpty()) {
					Name temp = queue.poll();

					for (int k = 0; k < 2; k++) {
						int nr = temp.row + Dr[k];
						int nc = temp.col + Dc[k];

						if (nr >= n || nc >= m || visit[nr][nc])
							continue;
						if (q.isEmpty())
							q.add(new Name(nr, nc, arr[nr][nc]));
						else if (q.peek().st > arr[nr][nc]) {
							q.clear();
							q.add(new Name(nr, nc, arr[nr][nc]));
						} else if (q.peek().st == arr[nr][nc])
							q.add(new Name(nr, nc, arr[nr][nc]));
						visit[nr][nc] = true;
					}
				}
				queue = q;

			}
			String s = new String(name);
			answer[test_case - 1] = s;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " +answer[test_case - 1]);
		}

	}
}