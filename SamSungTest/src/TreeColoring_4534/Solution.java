package TreeColoring_4534;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class Solution {
	static final int mod = 1000000007;
	static long dp[][];

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		long answer[] = new long[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();

			int parent[] = new int[n + 1];
			dp = new long[n+1][n+1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < n - 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				list.get(a).add(b);
				list.get(b).add(a);
				
			}
			long ans = solve(list, 0, 1, 0);
			ans += solve(list, 0, 1, 1);
			ans %= mod;
			answer[test_case - 1] = ans;

		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}

	static long solve(ArrayList<ArrayList<Integer>> list, int prev, int idx, int color) {
		long result = 1;
		if(dp[idx][color] != 0)
			return dp[idx][color];
		for (int temp : list.get(idx)) {
			if(prev == temp) continue;
			long sum = solve(list, idx, temp, 0);

			if (color == 0) {
				sum += solve(list, idx, temp, 1);
				sum %= mod;
			}

			result *= sum;
			result %= mod;
		}
		dp[idx][color] = result;
		return result;

	}
}