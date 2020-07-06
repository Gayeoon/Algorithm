package IntegerTriangle;

import java.util.Scanner;

public class Main {

	static int triangle[][];
	static int dp[][];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		triangle = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = input.nextInt();
			}
		}
		
		System.out.println(solve(0, 0));
	}
	
	static int solve(int row, int col) {
		if(row == n) return 0;
		if(dp[row][col] != 0) return dp[row][col];
		int max = triangle[row][col] + Math.max(solve(row+1, col), solve(row+1, col+1));
		dp[row][col] = max;
		return max;
	}

}
