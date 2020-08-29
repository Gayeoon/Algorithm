package B_2698;

import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();		
	}
	
	private static void solve() {
	    int t = input.nextInt();
	    int[][][] dp = new int[101][100][2];
	    StringBuilder sb = new StringBuilder();
	 
	    dp[1][0][1] = 1; // 1
	    dp[1][0][0] = 1; // 0
	 
	    for (int k = 0; k < 100; k++) {
	 
	        for (int n = 2; n <= 100; n++) {
	            if (k == 0) {
	                dp[n][k][1] += dp[n - 1][k][0];
	            } else {
	                dp[n][k][1] += dp[n - 1][k][0] + dp[n - 1][k - 1][1];
	            }
	            dp[n][k][0] += dp[n - 1][k][0] + dp[n - 1][k][1];
	        }
	 
	    }
	 
	    while (t-- > 0) {
	        int n = input.nextInt();
	        int k = input.nextInt();
	 
	        sb.append((dp[n][k][0] + dp[n][k][1]) + "\n");
	    }
	    System.out.println(sb.toString());
	}

}
