package SW_19237;

import java.util.Scanner;

class Smell {
	int idx, time;

	Smell(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}

class Shark {
	int row, col, d;
	int dir[][] = new int[4][4];
	boolean isLive;

	Shark(int row, int col) {
		this.row = row;
		this.col = col;
		this.isLive = true;
	}
}

public class Main {
	static int n, m, k;
	static Smell map[][];
	static Shark[] shark;
	static int Dr[] = { 0, -1, 1, 0 };
	static int Dc[] = { 1, 0, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();

		map = new Smell[n][n];
		shark = new Shark[m + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = input.nextInt();
				if (tmp == 0)
					map[i][j] = null;
				else {
					shark[tmp] = new Shark(i, j);
				}
			}
		}

		for (int i = 1; i <= m; i++) {
			shark[i].d = (input.nextInt() % 4);
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int d = 0; d < 4; d++) {
					shark[i].dir[(j % 4)][d] = (input.nextInt() % 4);
				}
			}
		}
		System.out.println(solve());
	}

	static int solve() {
		int cnt = m;
		for (int time = 1; time <= 1000; time++) {

			// 냄새를 남긴다
			for (int i = 1; i <= m; i++) {
				if (shark[i].isLive)
					map[shark[i].row][shark[i].col] = new Smell(i, k);
			}

			boolean visit[][] = new boolean[n][n];

			// 상어를 움직인다
			for (int i = 1; i <= m; i++) {
				if (!shark[i].isLive)
					continue;
				boolean flag = true;
				for (int idx = 0; idx < 4; idx++) {
					int nr = shark[i].row + Dr[shark[i].dir[shark[i].d][idx]];
					int nc = shark[i].col + Dc[shark[i].dir[shark[i].d][idx]];

					if (nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue;

					if (map[nr][nc] != null)
						continue;

					flag = false;
					if (visit[nr][nc]) {
						shark[i].isLive = false;
						cnt--;
						break;
					} else {
						visit[nr][nc] = true;
						shark[i].row = nr;
						shark[i].col = nc;
						shark[i].d = shark[i].dir[shark[i].d][idx];
						break;
					}
				}

				if (flag) {
					for (int idx = 0; idx < 4; idx++) {
						int nr = shark[i].row + Dr[shark[i].dir[shark[i].d][idx]];
						int nc = shark[i].col + Dc[shark[i].dir[shark[i].d][idx]];

						if (nr < 0 || nr >= n || nc < 0 || nc >= n)
							continue;

						if (map[nr][nc].idx == i) {
							visit[nr][nc] = true;
							shark[i].row = nr;
							shark[i].col = nc;
							shark[i].d = shark[i].dir[shark[i].d][idx];
							map[nr][nc] = new Smell(i, k);
							break;

						}
					}
				}
			}

			if (cnt == 1)
				return time;

			// 냄새를 지운다
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == null)
						continue;
					if (map[i][j].time == 1)
						map[i][j] = null;
					else
						map[i][j].time--;
				}
			}
		}
		return -1;
	}
}
