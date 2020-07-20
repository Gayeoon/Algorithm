package LCS_1958;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String a = input.next();
		String b = input.next();
		String c = input.next();

		int[][][] dp = new int[a.length() + 1][b.length() + 1][c.length() + 1];

		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				for (int k = 0; k <= c.length(); k++) {
					if(i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 0;
						continue;
					}
					if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j-1) == c.charAt(k-1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k-1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i][j - 1][k], dp[i - 1][j][k]);
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1]);
					}
				}
			}
		}
		
		System.out.println(dp[a.length()][b.length()][c.length()]);
	}

}
