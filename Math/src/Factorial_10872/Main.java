package Factorial_10872;

import java.util.Scanner;

public class Main {
	static int dp[];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		dp = new int[13];
		
		dp[0] = 1;
		dp[1] = 1;
		
		System.out.println(solve(n));
	}
	
	static int solve(int n) {
		if(dp[n] != 0)
			return dp[n];
		if(n <= 1)
			return dp[n];
		return dp[n] = n * solve(n-1);
	}
}
