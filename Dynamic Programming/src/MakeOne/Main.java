package MakeOne;

import java.util.Scanner;

public class Main {
	static int dp[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		dp = new int[1000001];
		dp[1] = 0;
		dp[2] = dp[3] = 1;
		System.out.println(solve(n));
	}

	static int solve(int n) {

		if (dp[n] != 0)
			return dp[n];

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;

			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}

		return dp[n];
	}

}
