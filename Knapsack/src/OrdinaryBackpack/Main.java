package OrdinaryBackpack;

import java.util.Scanner;

// Knapsack

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		
		int dp[] = new int[k+2];
		
		while(n > 0) {
			n--;
			
			int w = input.nextInt();
			int v = input.nextInt();
			
			for(int i=k; i>=w; i--) {
				dp[i] = Math.max(dp[i], dp[i-w] + v);
			}
		}
		
		System.out.println(dp[k]);
	}

}
