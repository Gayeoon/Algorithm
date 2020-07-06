package NQueen_2806;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution {
	static boolean[][] visit;

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
		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			visit = new boolean[n][n];
			if(n == 1)
				answer[test_case - 1] = 1;
			else
				answer[test_case - 1] = solve(n, 0, 0);
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static int solve(int n, int row, int cnt) {
		int count = 0;
		if (cnt == n)
			return 1;
		if (row >= n)
			return 0;
		for (int i = 0; i < n; i++) {
			if (check(n, row, i)) {
				visit[row][i] = true;
				count += solve(n, row + 1, cnt + 1);
				visit[row][i] = false;
			}
		}
		return count;
	}

	static boolean check(int n, int row, int col) {
		for (int i = 0; i < n; i++) {
			if (visit[row][i])
				return false;
			if (visit[i][col])
				return false;
		}

		int nr = row;
		int nc = col;
		int rowIdx = 0;
		int colIdx = 0;
		int[] Dr = { -1, -1, 1, 1 };
		int[] Dc = { -1, 1, -1, 1 };
		while (true) {
			if (rowIdx == 4)
				break;
			
			nr += Dr[rowIdx];
			nc += Dc[colIdx];

			if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
				rowIdx++;
				colIdx++;
				nr = row;
				nc = col;
				continue;
			}
			if (visit[nr][nc])
				return false;
		}

		return true;
	}
}