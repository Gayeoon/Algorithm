package MoveCandy;

import java.util.Scanner;

public class Main {

	static int arr[][];
	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		arr = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (i == 0 && j == 0) dp[0][0] = arr[0][0];
				else if(i == 0) dp[i][j] = dp[i][j-1] + arr[i][j];
				else if(j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j] + arr[i][j], dp[i][j-1] + arr[i][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + arr[i][j]);
				}
			}
		}
		
		System.out.println(dp[n-1][m-1]);
	}

}
