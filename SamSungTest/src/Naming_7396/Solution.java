package Naming_7396;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
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
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이 작성한 코드를
		 * 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때
		 * 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		 * 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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