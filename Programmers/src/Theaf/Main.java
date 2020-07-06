package Theaf;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] money = { 10,30,10,50,60,20};
		int[][] dp = new int[money.length][3];

		dp[0][0] = dp[0][2] = dp[1][1] = money[0];
		dp[0][1] = 0;
		dp[1][0] = money[1];
		dp[1][2] = Math.max(dp[1][0], dp[1][1]);
		for (int i = 2; i < money.length - 1; i++) {
			dp[i][0] = dp[i - 1][1] + money[i];
			dp[i][1] = dp[i - 1][2];
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}
		int max = dp[money.length - 2][2];

		dp[1][0] = dp[1][2] = dp[2][1] = money[1];
		dp[1][1] = 0;
		dp[2][0] = money[2];
		dp[2][2] = Math.max(dp[2][0], dp[2][1]);
		for (int i = 3; i < money.length; i++) {
			dp[i][0] = dp[i - 1][1] + money[i];
			dp[i][1] = dp[i - 1][2];
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}

		if (max < dp[money.length - 1][2])
			System.out.println(dp[money.length - 1][2]);
		else
			System.out.println(max);
	}
}