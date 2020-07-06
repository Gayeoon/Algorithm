package Palindrome_10942;

import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		arr = new int[n + 1];
		dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = input.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			dp[i][i] = 1;
			if (arr[i] == arr[i - 1]) {
				dp[i - 1][i] = 1;
			} else
				dp[i - 1][i] = 2;
		}

		int t = input.nextInt();

		for (int i = 0; i < t; i++) {
			int start = input.nextInt();
			int end = input.nextInt();
			int result = solve(start, end);
			if (result == 2)
				sb.append(0 + "\n");
			else
				sb.append(1 + "\n");
		}
		System.out.println(sb);
	}

	static int solve(int start, int end) {
		if (dp[start][end] != 0)
			return dp[start][end];

		if (arr[start] == arr[end]) {
			return dp[start][end] = solve(start + 1, end - 1);
		} else {
			return dp[start][end] = 2;
		}
	}

}
