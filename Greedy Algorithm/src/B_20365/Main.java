package B_20365;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int dp[][] = new int[n][2];
		String str = input.next();

		boolean blue = false, red = false;

		if(str.charAt(0) == 'B') {
			dp[0][0] = 1;
			dp[0][1] = 2;
		}else {
			dp[0][0] = 2;
			dp[0][1] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			char c = str.charAt(i);

			if (c == 'B') {
				if (!blue) {
					dp[i][0] = dp[i - 1][1] + 1;
					dp[i][1] = dp[i - 1][1] + 1;
					blue = true;
				} else {
					dp[i][0] = dp[i - 1][0];
					dp[i][1] = dp[i - 1][1] + 1;
				}
			} else {
				if (!red) {
					dp[i][0] = dp[i - 1][0] + 1;
					dp[i][1] = dp[i - 1][0] + 1;
					red = true;
				} else {
					dp[i][0] = dp[i - 1][0] + 1;
					dp[i][1] = dp[i - 1][1];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(dp[i][0]+" ");
		}
		System.out.println();
		for(int i=0; i<n; i++) {
			System.out.print(dp[i][1]+" ");
		}
System.out.println("\n");
		System.out.println(Math.min(dp[n-1][0], dp[n-1][1]));

	}

}
