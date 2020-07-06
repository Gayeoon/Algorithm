package OhMyGoddess_7793;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Location {
	int row, col;

	Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class Solution {	
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][m];
			
			// . = 0 / * - 1 / X - 2 / S - 3 / D - 4;
			Queue<Location> queue = new LinkedList<Location>();
			Queue<Location> sue = new LinkedList<Location>();
			for (int i = 0; i < n; i++) {
				String temp = sc.next();
				for (int j = 0; j < m; j++) {
					char str = temp.charAt(j);
					switch (str) {
					case '.':
						arr[i][j] = 0;
						break;
					case '*':
						queue.add(new Location(i, j));
						arr[i][j] = 1;
						break;
					case 'X':
						arr[i][j] = 2;
						break;
					case 'S':
						sue.add(new Location(i, j));
						arr[i][j] = 3;
						break;
					case 'D':
						arr[i][j] = 4;
						break;
					}
				}
			}
			boolean flag = false;
			int cnt = 0;
			int result = Integer.MAX_VALUE;
			while (true) {
				cnt++;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Location temp = queue.poll();
					int nRow = temp.row;
					int nCol = temp.col;
					for (int k = 0; k < 4; k++) {
						int nr = nRow + Dr[k];
						int nc = nCol + Dc[k];

						if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
							continue;
						if (arr[nr][nc] == 0 || arr[nr][nc] == 3) {
							arr[nr][nc] = 1;
							queue.add(new Location(nr, nc));
						}
					}
				}

				size = sue.size();
				for (int i = 0; i < size; i++) {
					Location temp = sue.poll();
					int nRow = temp.row;
					int nCol = temp.col;
					for (int k = 0; k < 4; k++) {
						int nr = nRow + Dr[k];
						int nc = nCol + Dc[k];

						if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
							continue;
						if (arr[nr][nc] == 0) {
							arr[nr][nc] = 3;
							sue.add(new Location(nr, nc));
						} else if (arr[nr][nc] == 4) {
							result = Math.min(result, cnt);
							flag = true;
							break;
						}
					}
				}
				if (sue.isEmpty())
					break;
			}

			if (!flag)
				answer[test_case - 1] = -1;
			else
				answer[test_case - 1] = result;
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			if (answer[test_case - 1] == -1)
				System.out.println("GAME OVER");
			else
				System.out.println(answer[test_case - 1]);
		}
	}
}