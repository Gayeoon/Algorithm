package EasyStairs;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int dp[][] = new int[101][10];
		
		for(int k=1; k<10; k++) {
			dp[1][k] = 1;			
		}
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) dp[i][j] = dp[i-1][1];
				else if(j == 9) dp[i][j] = dp[i-1][8];
				else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
		}
		
		int sum =0;
		for(int k=0; k<10; k++) {
			sum += dp[n][k];
			sum %= 1000000000;
		}
		
		System.out.println(sum);
	}

}
