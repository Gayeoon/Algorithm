package B_2931;

import java.util.HashMap;
import java.util.Scanner;

class Dot {
	int row, col, dir;

	Dot(int row, int col, int dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
}

public class Main {
	static char[][] europ;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static boolean visit[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		HashMap<Integer, Character> pipe = new HashMap<>();
		pipe.put(5, '|');
		pipe.put(25, '-');
		pipe.put(30, '+');
		pipe.put(20, '1');
		pipe.put(17, '2');
		pipe.put(10, '3');
		pipe.put(13, '4');
		Dot M = null, Z = null;
		europ = new char[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String temp = input.next();
			for (int j = 0; j < m; j++) {
				europ[i][j] = temp.charAt(j);
				if (europ[i][j] == 'M') {
					M = new Dot(i, j, 0);
				} else if (europ[i][j] == 'Z') {
					Z = new Dot(i, j, 0);
				}
			}
		}
		Dot temp = find(M.row, M.col, 'M', 0, 'M');
		int dirc[] = { 1, 0, 3, 2 };
		if (temp.row == M.row && temp.col == M.col) {
			int[] plus = { 1, 4, 9, 16 };
			Dot temp2 = find(Z.row, Z.col, 'Z', 0, 'Z');
			int sum = plus[dirc[temp2.dir]];
			if (temp2.row == Z.row && temp2.col == Z.col) {
				int t=0;
				for (int i = 0; i < 4; i++) {
					int nr = Dr[i] + temp2.row;
					int nc = Dc[i] + temp2.col;

					if (nr < 0 || nr >= europ.length || nc < 0 || nc >= europ[0].length)
						continue;
					if (europ[nr][nc] == 'M')
						break;
					sum = plus[dirc[i]];
					for (int j = 0; j < 4; j++) {
						if (j == dirc[i])
							continue;
						int nnr = Dr[j] + nr;
						int nnc = Dc[j] + nc;

						if (nnr < 0 || nnr >= europ.length || nnc < 0 || nnc >= europ[0].length)
							continue;

						if (europ[nnr][nnc] == 'M')
							t = (j + 1) * (j + 1);
						else if (check(europ[nnr][nnc], j)) {
							sum += (j + 1) * (j + 1);
						}
					}
					if (pipe.containsKey(sum)) {
						System.out.println((nr + 1) + " " + (nc + 1) + " " + pipe.get(sum));
						break;
					}else if (pipe.containsKey(sum+t)) {
						System.out.println((nr + 1) + " " + (nc + 1) + " " + pipe.get(sum+t));
						break;
					}
				}

			} else {
				int t = 0;
				for (int i = 0; i < 4; i++) {
					if (i == dirc[temp2.dir])
						continue;
					int nr = Dr[i % 4] + temp2.row;
					int nc = Dc[i % 4] + temp2.col;

					if (nr < 0 || nr >= europ.length || nc < 0 || nc >= europ[0].length)
						continue;

					if (europ[nr][nc] == 'M')
						t = (i + 1) * (i + 1);
					else if (check(europ[nr][nc], i)) {
						sum += (i + 1) * (i + 1);
					}
				}
				if (pipe.containsKey(sum))
					System.out.println((temp2.row + 1) + " " + (temp2.col + 1) + " " + pipe.get(sum));
				else if (pipe.containsKey(sum + t))
					System.out.println((temp2.row + 1) + " " + (temp2.col + 1) + " " + pipe.get(sum+t));
			}

		} else {
			int[] plus = { 4, 1, 16, 9 };
			int sum = plus[temp.dir];
			int t = 0;
			for (int i = 0; i < 4; i++) {
				if (i == dirc[temp.dir])
					continue;
				int nr = Dr[i] + temp.row;
				int nc = Dc[i] + temp.col;

				if (nr < 0 || nr >= europ.length || nc < 0 || nc >= europ[0].length)
					continue;
				if (europ[nr][nc] == 'Z')
					t = (i + 1) * (i + 1);
				else if (check(europ[nr][nc], i)) {
					sum += (i + 1) * (i + 1);
				}
			}
			if (pipe.containsKey(sum))
				System.out.println((temp.row + 1) + " " + (temp.col + 1) + " " + pipe.get(sum));
			else if (pipe.containsKey(sum + t))
				System.out.println((temp.row + 1) + " " + (temp.col + 1) + " " + pipe.get(sum + t));
		}
	}

	static boolean check(char target, int dir) {
		switch (target) {
		case '.':
			return false;
		case '|':
			if (dir == 0 || dir == 1)
				return true;
			else
				return false;
		case '-':
			if (dir == 2 || dir == 3)
				return true;
			else
				return false;
		case '+':
			return true;
		case '1':
			if (dir == 0 || dir == 2)
				return true;
			else
				return false;
		case '2':
			if (dir == 1 || dir == 2)
				return true;
			else
				return false;
		case '3':
			if (dir == 1 || dir == 3)
				return true;
			else
				return false;
		case '4':
			if (dir == 0 || dir == 3)
				return true;
			else
				return false;
		default:
			return false;
		}
	}

	// dir = {¾Æ·¡->À§, À§- > ¾Æ·¡, ¿À->¿Þ, ¿Þ->¿À}
	static Dot find(int row, int col, char now, int dir, char target) {
		if (now == '.') {
			return new Dot(row, col, dir);
		} else if (now == '|') {
			int nr = row + Dr[dir];
			return find(nr, col, europ[nr][col], dir, target);
		} else if (now == '-') {
			int nc = col + Dc[dir];
			return find(row, nc, europ[row][nc], dir, target);
		} else if (now == '+') {
			int nr = row + Dr[dir];
			int nc = col + Dc[dir];
			return find(nr, nc, europ[nr][nc], dir, target);
		} else if (now == '1') {
			if (dir == 0) {
				return find(row, col + 1, europ[row][col + 1], 3, target);
			} else {
				return find(row + 1, col, europ[row + 1][col], 1, target);
			}
		} else if (now == '2') {
			if (dir == 1) {
				return find(row, col + 1, europ[row][col + 1], 3, target);
			} else {
				return find(row - 1, col, europ[row - 1][col], 0, target);
			}
		} else if (now == '3') {
			if (dir == 1) {
				return find(row, col - 1, europ[row][col - 1], 2, target);
			} else {
				return find(row - 1, col, europ[row - 1][col], 0, target);
			}
		} else if (now == '4') {
			if (dir == 0) {
				return find(row, col - 1, europ[row][col - 1], 2, target);
			} else {
				return find(row + 1, col, europ[row + 1][col], 1, target);
			}
		} else if (now == target) {
			for (int i = 0; i < 4; i++) {
				int nr = row + Dr[i];
				int nc = col + Dc[i];

				if (nr < 0 || nr >= europ.length || nc < 0 || nc >= europ[0].length)
					continue;
				else if (europ[nr][nc] == '.')
					continue;
				else if (check(europ[nr][nc], i)) {
					return find(nr, nc, europ[nr][nc], i, target);
				}
			}
		}
		return new Dot(row, col, dir);
	}

}
