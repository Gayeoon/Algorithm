package NIM_GAME_9655;

import java.util.Scanner;

public class Main {
	static int dp[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int rock = input.nextInt();
		dp = new int[rock+1];
		
		int result = solve(rock, 1, 2);
		if(result == 1)
			System.out.print("SK");
		else
			System.out.print("CY");
		
	}

	public static int solve(int rock, int me, int you) {
		if(rock == 3 || rock == 1)
			return dp[rock] = me;
		if(rock == 2)
			return dp[rock] = you;
		
		if(dp[rock] != 0)
			return dp[rock];
		
		int tmp = solve(rock-1, you, me);
		int result = me;
		if(tmp != me) {
			tmp = solve(rock-3, you, me);
			if(tmp != me)
				result = you;
		}
		return dp[rock] = result;
	}
}
