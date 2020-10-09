package S_3376;

import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			if (n <= 3)
				sb.append("#" + test_case + " " + 1 + "\n");
			else if (n <= 5)
				sb.append("#" + test_case + " " + 2 + "\n");
			else {
				long[] dp = new long[n];

				dp[0] = dp[1] = dp[2] = 1;
				dp[3] = dp[4] = 2;

				for (int i = 5; i < n; i++) {
					dp[i] = dp[i - 1] + dp[i - 5];
				}
				sb.append("#" + test_case + " " + dp[n - 1] + "\n");
			}
		}
		System.out.print(sb);
	}
}