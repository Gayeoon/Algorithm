package SW_14500;

import java.util.Scanner;

class Point {
	int row, col, cnt, val;

	Point(int row, int col, int cnt, int val) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.val = val;
	}
}

public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		arr = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = true;
				result = Math.max(result, solve(i, j, n, m, 1));
				visit[i][j] = false;
				result = Math.max(result, cross(i, j, n, m));
			}
		}
		System.out.println(result);
	}

	static int solve(int row, int col, int n, int m, int cnt) {
		if (cnt >= 4) {
			return arr[row][col];
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc]) {
				continue;
			}

			visit[nr][nc] = true;

			result = Math.max(result, arr[row][col] + solve(nr, nc, n, m, cnt + 1));
			visit[nr][nc] = false;
		}
		return result;
	}

	static int cross(int row, int col, int n, int m) {
		int sum = arr[row][col];
		int wing = 4;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (wing <= 2)
				return 0;

			if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
				wing--;
				continue;
			}
			min = Math.min(min, arr[nr][nc]);
			sum += arr[nr][nc];
		}

		if (wing == 3)
			return sum;
		return sum - min;
	}
}
