package FindRoute;
import java.util.stream.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 9;
		int n = 4;
		int[][] puddles = { { 2, 1 }, {1, 3}, {5, 4}};

		int dp[][] = new int[n][m];
		int route[][] = new int[n][m];

		int[] temp = {1,2,3,4,5,6,7,8,9,10};
	
		
		for (int i = 0; i < puddles.length; i++) {
			route[puddles[i][1]-1][puddles[i][0]-1] = -1;
		}
		
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(route[i][j] == -1) dp[i][j] = 0;
				else {
					if(i > 0) dp[i][j] = (dp[i][j]+dp[i-1][j])%1000000007; 
					if(j > 0) dp[i][j] = (dp[i][j]+dp[i][j-1])%1000000007; 
				}
			}
		}
		
	}

}
