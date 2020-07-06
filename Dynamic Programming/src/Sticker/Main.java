package Sticker;

import java.util.Scanner;

public class Main {

	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();
		int question[] = new int[test];

		for (int t = 0; t < test; t++) {
			int n = input.nextInt();
			int arr[][] = new int[2][n];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = input.nextInt();
				}
			}

			dp = new int[2][n];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];

			question[t] = solve(arr);
		}
		for (int t = 0; t < test; t++) {
			System.out.println(question[t]);
		}
	}

	static int solve(int[][] arr) {
		for (int j = 1; j < arr[0].length; j++) {
			dp[0][j] = Math.max(dp[1][j - 1] + arr[0][j], dp[0][j - 1]);
			dp[1][j] = Math.max(dp[0][j - 1] + arr[1][j], dp[1][j - 1]);
		}
		return Math.max(dp[0][arr[0].length-1], dp[1][arr[0].length-1]);
	}

}
