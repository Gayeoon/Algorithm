package ClimStairs;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] dp = new int[n][3];
		int[] stairs = new int[n];

		for (int i = 0; i < n; i++) {
			stairs[i] = input.nextInt();
		}

		if (n <= 2) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += stairs[i];
			}
			System.out.println(sum);
		} else {
			dp[0][0] = dp[0][1] = dp[0][2] = stairs[0];
			dp[1][0] = dp[1][2] = stairs[1] + dp[0][0];
			dp[1][1] = stairs[1];

			for (int i = 2; i < n; i++) {
				dp[i][0] = stairs[i] + dp[i - 1][1];
				dp[i][1] = stairs[i] + dp[i - 2][2];
				dp[i][2] = Math.max(dp[i][0], dp[i][1]);
			}
			System.out.println(dp[n - 1][2]);
		}
	}

}
