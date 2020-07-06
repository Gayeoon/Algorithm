package Combination;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BigInteger dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		dp = new BigInteger[n+1][m+1];
		
		System.out.println(combination(n, m));
	}

	static BigInteger combination(int n, int r) {
		if (n == r || r == 0)
			return BigInteger.ONE;
		else if (dp[n][r] != null)
			return dp[n][r];
		else {
			dp[n][r] = combination(n - 1, r - 1).add(combination(n - 1, r));
			return dp[n][r];
		}
	}
}
