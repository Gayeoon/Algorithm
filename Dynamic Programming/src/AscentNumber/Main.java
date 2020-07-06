package AscentNumber;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt()-1;
		
		int dp[][] = new int[n+1][10];
		int sum = 0;
		
		for(int i=0; i<10; i++) {
			dp[0][i] = 1;
			sum += 1;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) {
					dp[i][j] = sum;
					sum = 0;
				}
				else {
					dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
					dp[i][j] = (dp[i][j] + 10007) % 10007;
				}
				sum += dp[i][j];
				sum %= 10007;
			}
		}
		
		System.out.println(sum);
	}

}
