package TSP_1247;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Location {
	int row, col;

	Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class Solution {
//	static boolean visit[];
	static int dp[][];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<Location> list = new ArrayList<>();
			int n = sc.nextInt();
//			visit = new boolean[n + 1];
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.add(new Location(a, b));
			a = sc.nextInt();
			b = sc.nextInt();
			Location home = new Location(a, b);

			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				list.add(new Location(a, b));
			}
//			Stack<Integer> stack = new Stack<>();
//			visit[0] = true;
//			int result = solve(list, home, 0, 0, stack);
			dp = new int[n + 1][1 << list.size()];
			int result = TSP(list, home, 0, 1);
			answer[test_case - 1] = result;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}

//	static int solve(ArrayList<Location> list, Location home, int index, int dis, Stack<Integer> stack) {
//		if (stack.size() == list.size()) {
//			dis += Math.abs(home.row - list.get(index).row) + Math.abs(home.col - list.get(index).col);
//			return dis;
//		}
//		int result = Integer.MAX_VALUE;
//		for (int i = 1; i < list.size(); i++) {
//			if (visit[i])
//				continue;
//			stack.add(i);
//			visit[i] = true;
//			result = Math.min(result, solve(list, home, i, dis + Math.abs(list.get(i).row - list.get(index).row)
//					+ Math.abs(list.get(i).col - list.get(index).col), stack));
//			stack.pop();
//			visit[i] = false;
//		}
//		return result;
//	}

	static int TSP(ArrayList<Location> list, Location home, int index, int visited) {

		if (visited == (1 << list.size()) - 1) {
			int dis = Math.abs(home.row - list.get(index).row) + Math.abs(home.col - list.get(index).col);
			return dis;
		}

		if (dp[index][visited] != 0) {
			return dp[index][visited];
		}

		int result = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			if ((visited & (1 << i)) == 0) {
				int temp = Math.abs(list.get(i).row - list.get(index).row)
						+ Math.abs(list.get(i).col - list.get(index).col);
				result = Math.min(result, temp + TSP(list, home, i, visited | (1 << i)));
			}
		}

		dp[index][visited] = result;
		return dp[index][visited];
	}

	static String bytesToBinaryString(Byte b) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			builder.append(((0x80 >>> i) & b) == 0 ? '0' : '1');
		}

		return builder.toString();
	}
}
