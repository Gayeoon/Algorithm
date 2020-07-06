package PinaryNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static long[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		dp = new long[91];
		Arrays.fill(dp, -1);
		dp[0] = dp[1] = dp[2] = 1;
		
		if(n == 0 || n == 1 || n == 2)
			System.out.println(1);
		else {
			System.out.println(solve(n));
		}
	}
	
	static long solve(int n) {
		if(dp[n] != -1)
			return dp[n];
		long result = solve(n-1) + solve(n-2);
		dp[n] = result;
		return result;
	}

}
