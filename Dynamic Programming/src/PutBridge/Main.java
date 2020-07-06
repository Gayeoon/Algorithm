package PutBridge;

import java.util.Scanner;

public class Main {
	static int dp[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[][] question = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			question[i][0] = input.nextInt();
			question[i][1] = input.nextInt();
		}

		for (int i = 0; i < n; i++) {
			dp = new int[question[i][0]][question[i][1]];
			System.out.println(solve(question[i][0], question[i][1]));
		}

	}
	static int solve(int n, int m) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i == j) dp[i][j] = 1;
				if(i == 0) dp[i][j] = j+1;
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<m; j++) {
				for(int k=j-1; k>=i-1; k--) {
					dp[i][j] += dp[i-1][k];
				}
			}
		}
		return dp[n-1][m-1];
		
	}
}
