package SW_17144;

import java.util.Scanner;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int n, m;
	static Point cleaner[];
	static int Dr[] = { -1, 0, 1, 0 };
	static int Dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		int T = input.nextInt();

		int arr[][] = new int[n][m];
		cleaner = new Point[2];

		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();

				if (arr[i][j] == -1)
					cleaner[idx++] = new Point(i, j);
			}
		}

		System.out.println(solve(arr, 0, T));


	}

	static int solve(int[][] arr, int time, int T) {
		
		if (time == T) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] <= 0)
						continue;
					sum += arr[i][j];
				}
			}
			return sum;
		}
		
		
		int map[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] <= 0)
					continue;
				int A = arr[i][j] / 5;
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + Dr[k];
					int nc = j + Dc[k];

					if (nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] < 0)
						continue;
					map[nr][nc] += A;
					cnt++;
				}
				map[i][j] += arr[i][j] - (A * cnt);
			}
		}

		int dir = 0;
		int row = cleaner[0].row;
		int col = cleaner[0].col;
		while (true) {
			int nr = row + Dr[dir];
			int nc = col + Dc[dir];
			if (nr == cleaner[0].row & nc == cleaner[0].col) {
				map[row][col] = 0;
				break;
			}
			if (nr < 0 || nr >= n || nc < 0 || nc >= m || nr > cleaner[0].row) {
				dir = (dir + 1) % 4;
				continue;
			}
			map[row][col] = map[nr][nc];
			row = nr;
			col = nc;
		}
		map[cleaner[0].row][cleaner[0].col] = -1;

		dir = 2;
		row = cleaner[1].row;
		col = cleaner[1].col;
		while (true) {
			int nr = row + Dr[dir];
			int nc = col + Dc[dir];
			if (nr == cleaner[1].row & nc == cleaner[1].col) {
				map[row][col] = 0;
				break;
			}
			if (nr < 0 || nr >= n || nc < 0 || nc >= m || nr < cleaner[1].row) {
				dir--;
				if (dir < 0)
					dir = 3;
				continue;
			}
			map[row][col] = map[nr][nc];
			row = nr;
			col = nc;
		}
		map[cleaner[1].row][cleaner[1].col] = -1;

		return solve(map, time + 1, T);
	}
}
