package S_1873;

import java.util.Scanner;

public class Solution {
	static int[] Dr = { -1, 0, 1, 0 };
	static int[] Dc = { 0, 1, 0, -1 };
	static char[][] arr;
	static int row, col, dir;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		char[] tank = { '^', '>', 'v', '<' };
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			arr = new char[n][m];
			row = col = 0;
			dir = -1;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.charAt(j);

					if (dir == -1) {
						switch (arr[i][j]) {
						case '^':
							row = i;
							col = j;
							dir = 0;
							break;
						case '>':
							row = i;
							col = j;
							dir = 1;
							break;
						case 'v':
							row = i;
							col = j;
							dir = 2;
							break;
						case '<':
							row = i;
							col = j;
							dir = 3;
							break;
						default:
							break;
						}
						if (dir != -1)
							arr[i][j] = '.';
					}
				}
			}
			int len = sc.nextInt();
			String str = sc.next();

			for (int i = 0; i < len; i++) {
				switch (str.charAt(i)) {
				case 'S':
					shooting();
					break;
				case 'U':
					move(0);
					break;
				case 'R':
					move(1);
					break;
				case 'D':
					move(2);
					break;
				case 'L':
					move(3);
					break;
				default:
					break;
				}
			}
			arr[row][col] = tank[dir];
			sb.append("#" + test_case + " ");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	static void move(int d) {
		dir = d;

		int nr = row + Dr[dir];
		int nc = col + Dc[dir];

		if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
			return;
		if (arr[nr][nc] == '.') {
			row = nr;
			col = nc;
		}
	}

	static void shooting() {
		int nr = row;
		int nc = col;

		while (true) {
			nr += Dr[dir];
			nc += Dc[dir];
			if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
				break;
			if (arr[nr][nc] == '*') {
				arr[nr][nc] = '.';
				break;
			}
			if (arr[nr][nc] == '#')
				break;
		}
	}
}