package TSP_10971;

import java.util.Scanner;

public class Main {
	static int arr[][];
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		arr = new int[n][n];
		dp = new int[n][(int) Math.pow(2, n)];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			dp = new int[n][(int) Math.pow(2, n)];
			result = Math.min(result, solve(i, (0 | (1 << i)), i));
		}
		System.out.print(result);
	}
	
	static int solve(int idx, int visit, int home) {
		if(visit == ((1 << arr.length)-1)) {
			if(arr[idx][home] != 0)
				return arr[idx][home];
			else
				return Integer.MAX_VALUE;
			
		}
		
		if(dp[idx][visit] != 0)
			return dp[idx][visit];
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[idx][i] != 0 & ((visit & (1<<i)) == 0)) {
				int tmp = solve(i, (visit | (1<<i)), home);
				if(tmp == Integer.MAX_VALUE)
					continue;
				result = Math.min(result, arr[idx][i] + tmp);
			}
		}
		return dp[idx][visit] = result;
	}

}
