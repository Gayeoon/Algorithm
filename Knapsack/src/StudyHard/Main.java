package StudyHard;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int t = input.nextInt();

		int[] time = new int[n];
		int[] score = new int[n];

		int[] dp = new int[10001];

		while (n > 0) {
			n--;
			int k = input.nextInt();
			int s = input.nextInt();

			for (int i = t; i >= k; i--)
				dp[i] = Math.max(dp[i], dp[i - k] + s);
		}
		System.out.println(dp[t]);
	}
}
