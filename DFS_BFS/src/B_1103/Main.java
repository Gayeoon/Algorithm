package B_1103;

import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static int[][] dp;

	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	static int max = 1;
	static boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		arr = new int[n][m];
		dp = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = input.next();

			for (int c = 0; c < tmp.length(); c++) {
				if (tmp.charAt(c) == 'H')
					arr[i][c] = 0;
				else
					arr[i][c] = Integer.parseInt(tmp.charAt(c) + "");
			}
		}

		visit[0][0] = true;
		solve(0,0,1);
		System.out.println(max);
	}

	static void solve(int row, int col, int depth) {
		if(flag) return;
		
		dp[row][col] = depth;
		max = Math.max(dp[row][col], max);
		
		for (int i = 0; i < 4; i++) {
			int nr = row + (Dr[i] * arr[row][col]);
			int nc = col + (Dc[i] * arr[row][col]);

			if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length || arr[nr][nc] == 0)
				continue;

			if(visit[nr][nc]) {
				flag = true;
				max = -1;
				return;
			}
				
				
			if (dp[nr][nc] >= depth + 1)
				continue;

			visit[nr][nc] = true;
			solve(nr, nc, depth + 1);
			visit[nr][nc] = false;
		}
	}
}
