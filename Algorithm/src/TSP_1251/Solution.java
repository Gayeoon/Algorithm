package TSP_1251;

import java.util.ArrayList;
import java.util.Scanner;

class Location {
	int x, y;

	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static ArrayList<Location> list;
	static double E = 0;
	static boolean visited[][];
	static long dp[][];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			list = new ArrayList<>();
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				list.add(new Location(sc.nextInt(), sc.nextInt()));
			}
			visited = new boolean[n][n];
			dp = new long[n][(int) Math.pow(2, n)];
			E = sc.nextDouble();

			sb.append("#" + test_case + " " + tsp(0, 1) + "\n");
		}
		System.out.print(sb);
	}

	static long tsp(int idx, int visit) {
		if (visit == ((1 << list.size()) - 1)) {
			return 0;
		}

		if (dp[idx][visit] != 0)
			return dp[idx][visit];

		long result = 0;
		for (int i = 0; i < list.size(); i++) {
			if ((visit & (1 << i)) == 0) {
				result = Math.max(result, dist(idx, i) + tsp(i, visit | (1 << i)));
			}
		}

		return dp[idx][visit] = result;

	}

	static long dist(int a, int b) {
		int x = Math.abs(list.get(a).x - list.get(b).x);
		int y = Math.abs(list.get(a).y - list.get(b).y);
		return (long) (E * ((x * x) + (y * y)));
	}
}