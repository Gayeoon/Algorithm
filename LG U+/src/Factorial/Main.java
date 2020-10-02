package Factorial;

public class Main {
	static int[] recursive;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;

		// Àç±Í »ç¿ë
		recursive = new int[n + 1];
		recursive[0] = recursive[1] = 1;
		System.out.println("Àç±Í : " + solve(n));

		// DP »ç¿ë
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			dp[i] = i * dp[i - 1];
		}
		System.out.println("DP : " + dp[n]);
	}

	static int solve(int n) {
		if (recursive[n] != 0)
			return recursive[n];
		return recursive[n] = n * solve(n-1);
	}
}
