package LCS_9251;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String a = input.next();
		String b = input.next();
		
		int dp[][] = new int[a.length()+1][b.length()+1];
		
		for(int i=0; i<a.length()+1; i++) {
			for(int j=0; j<b.length()+1; j++) {
				if(i == 0|| j==0) 
					continue;
				
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[a.length()][b.length()]);
	}

}
