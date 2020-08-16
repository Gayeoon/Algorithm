package Test_Three;

import java.util.Arrays;

public class Main_Three {
	static int dp[][];

	public static void main(String[] args) {
		dp = new int[4][4];
		int[][] board = { { 3, 2, 3, 2 }, { 2, 1, 1, 2 }, { 1, 1, 2, 1 }, { 4, 1, 1, 1 } };
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			Arrays.fill(dp[i], 1);
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				boolean visit[][] = new boolean[4][4];
				answer = Math.max(answer, solve(board, visit, i, j));
			}
		}

		System.out.println(answer);

	}

	private static int solve(int[][] board, boolean[][] visit, int row, int col) {
		// TODO Auto-generated method stub
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };

		int color = board[row][col];
		visit[row][col] = true;
		if (dp[row][col] != 1)
			return dp[row][col];
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];
			if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || visit[nr][nc])
				continue;
			if (board[nr][nc] != color)
				continue;
			dp[row][col] = Math.max(dp[row][col], 1+solve(board, visit, nr, nc));
		}
		return dp[row][col];
	}

}
