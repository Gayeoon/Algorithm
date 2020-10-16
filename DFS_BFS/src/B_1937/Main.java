package B_1937;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Panda {
	int row, col, val, time;

	Panda(int row, int col, int val, int time) {
		this.row = row;
		this.col = col;
		this.val = val;
		this.time = time;
	}
}

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static boolean visit[][];
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();

		arr = new int[N][N];
		dp = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.nextInt();
				dp[i][j] = -1;
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = true;
				result = Math.max(result, solve(i, j, arr[i][j]));
				visit[i][j] = false;
			}
		}

		System.out.println(result);

	}

	static int solve(int row, int col, int val) {
		if (dp[row][col] != -1)
			return dp[row][col];
		
		int result = 1;

		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
				continue;

			if (arr[nr][nc] <= val)
				continue;

			visit[nr][nc] = true;
			result = Math.max(result, 1 + solve(nr, nc, arr[nr][nc]));
			visit[nr][nc] = false;
		}

		return dp[row][col] = result;
	}

}
