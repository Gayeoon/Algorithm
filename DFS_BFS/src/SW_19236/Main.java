package SW_19236;

import java.util.Scanner;

class Fish {
	int row, col, dir;
	boolean flag;

	Fish(int row, int col, int dir, boolean flag) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.flag = flag;
	}
}

public class Main {
	static int[] Dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] Dc = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int result = 0;
	static int[][] arr = new int[4][4];
	static Fish[] fish = new Fish[17];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = input.nextInt();
				fish[arr[i][j]] = new Fish(i, j, input.nextInt() - 1, true);
			}
		}

		result = arr[0][0];
		fish[arr[0][0]].flag = false;
		arr[0][0] = -1;

		eatFish(0, 0, fish[result].dir, result);
		System.out.println(result);

	}

	static void eatFish(int row, int col, int dir, int sum) {
		Fish[] tmpFish = new Fish[17];
		int[][] tmpArr = new int[4][4];

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				tmpArr[i][j] = arr[i][j];

		for (int i = 1; i <= 16; i++)
			tmpFish[i] = fish[i];

		fishMove();

		for (int i = 1; i <= 3; i++) {
			int nr = row + (i * Dr[dir]);
			int nc = col + (i * Dc[dir]);

			if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {
				break;
			}
			if (arr[nr][nc] == 0)
				continue;

			arr[row][col] = 0;
			int n = arr[nr][nc];
			arr[nr][nc] = -1;
			fish[n].flag = false;

			eatFish(nr, nc, fish[n].dir, sum + n);

			fish[n].flag = true;
			arr[nr][nc] = n;
			arr[row][col] = -1;
		}

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				arr[i][j] = tmpArr[i][j];

		for (int i = 1; i <= 16; i++)
			fish[i] = tmpFish[i];

		result = Math.max(result, sum);
	}

	static void fishMove() {
		for (int i = 1; i <= 16; i++) {
			if (!fish[i].flag)
				continue;

			Fish cur = fish[i];
			int nd = cur.dir;
			int nr = cur.row;
			int nc = cur.col;

			while (true) {
				nr = cur.row + Dr[nd];
				nc = cur.col + Dc[nd];

				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || arr[nr][nc] == -1) {
					nd = (nd + 1) % 8;
					continue;
				}

				break;
			}

			int temp = arr[nr][nc];
			arr[nr][nc] = arr[cur.row][cur.col];
			arr[cur.row][cur.col] = temp;

			fish[i] = new Fish(nr, nc, nd, true);

			if (temp != 0) {
				fish[temp] = new Fish(cur.row, cur.col, fish[temp].dir, true);
			}
		}
	}

}
