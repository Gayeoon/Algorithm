package StationInstall_9327;

import java.util.Scanner;

public class Main {
	static int dp[];
	static boolean visit[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] cost = new int[n+1];
			int station[][] = new int[n+1][n+1];
			dp = new int[n+1];
			visit = new boolean[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				cost[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				int c = sc.nextInt();
				station[v1][v2] = station[v2][v1] = c;
			}

			
		}
	}
	static int dfs(int[] cost, int[][] station, int v, int max) {

		for(int i=0; i<station.length; i++) {
			if(station[v][i] != 0 && !visit[v][i]) {
				visit[v][i] = visit[i][v] = true;
				int temp = station[v][i] + dfs(cost, station, i, station[v][i] + max);
				dp[v] = Math.max(temp, dp[v]);
				visit[v][i] = visit[i][v] = false;
			}
			
		}
		return dp[v]-cost[v];
	}
}