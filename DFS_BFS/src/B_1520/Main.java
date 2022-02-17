package B_1520;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int arr[][];
	static int dp[][];
	static boolean visit[][];
	
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		arr = new int[N][M];
		dp = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		visit[0][0] = true;
		System.out.println(dfs(0, 0));

	}

	static int dfs(int row, int col) {
		if(row == N-1 && col == M-1)
			return 1;
		
		if (dp[row][col] != -1)
			return dp[row][col];

		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || arr[nr][nc] >= arr[row][col])
				continue;
			
			visit[nr][nc] = true;
			cnt += dfs(nr, nc);
			visit[nr][nc] = false;
			
		}

		return dp[row][col] = cnt;
		
	}
}
