package B_11726;

import java.util.Scanner;

public class Main {
	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		dp = new int[n + 1];

		System.out.println(solve(n));
	}

	static int solve(int num) {
		if (num == 0 || num == 1)
			return 1;

		if (dp[num] != 0)
			return dp[num];

		return dp[num] = (solve(num - 2) + solve(num - 1)) % 10007;
	}

}
