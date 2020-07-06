package Wine;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int wine[] = new int[n];
		int dp[] = new int[n + 1];

		for (int i = 0; i < n; i++) {
			wine[i] = input.nextInt();
		}

		Arrays.fill(dp, 0);
		dp[1] = wine[0];
		if(n > 1) dp[2] = wine[0] + wine[1];

		for (int i = 3; i < n + 1; i++) {
			dp[i] = Math.max(wine[i - 1] + wine[i - 2] + dp[i - 3], wine[i - 1] + dp[i - 2]);
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		System.out.println(dp[n]);
	}

}
