package Fibonacci;

public class Main {
	static int[] recursive;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		
		// Àç±Í »ç¿ë
		recursive = new int[n+1];
		recursive[0] = recursive[1] = 1;
		System.out.println("Àç±Í : "+solve(n));
	
		// DP »ç¿ë
		int[] dp = new int[n+1];
		dp[0] = dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println("DP : "+dp[n]);
	}

	static int solve(int n) {
		if(recursive[n] != 0)
			return recursive[n];
		return recursive[n] = solve(n-1) + solve(n-2);
	}
}
