package StringandScore;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		String str1 = input.next();
		String str2 = input.next();

		long[][] dp = new long[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < str1.length() + 1; i++)
			dp[i][0] = i * B;
		for (int i = 0; i < str2.length() + 1; i++)
			dp[0][i] = i * B;

		dp[0][0] = 0;
		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				long temp;
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					temp = dp[i - 1][j - 1] + A;
				} else {
					temp = dp[i - 1][j - 1] + C;
				}
				dp[i][j] = Math.max(temp, dp[i - 1][j] + B);
				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + B);

			}
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
