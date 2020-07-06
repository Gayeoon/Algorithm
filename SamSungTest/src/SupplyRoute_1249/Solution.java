package SupplyRoute_1249;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.io.FileInputStream;

class Point {
	int row, col, val;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class Solution {
	static boolean visit[][];
	static int arr[][];
	static int dp[][];
	static int min;
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			int n = sc.nextInt();
			arr = new int[n][n];
			dp = new int[n][n];
			visit = new boolean[n][n];
			int[][] result = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str.charAt(j) + "");
				}
			}
			bfs(0, 0);
			answer[test_case - 1] = min;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static void bfs(int row, int col) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(row, col));
		visit[0][0] = true;
		while (true) {
			if (queue.isEmpty())
				break;
			Point temp = queue.poll();
			if (temp.row == arr.length - 1 && temp.col == arr[0].length - 1) {
				min = Math.min(min, dp[temp.row][temp.col]);
			}
			if (min <= dp[temp.row][temp.col])
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];
				if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
					continue;
				if (!visit[nr][nc] || dp[nr][nc] > dp[temp.row][temp.col] + arr[nr][nc]) {
					visit[nr][nc] = true;
					dp[nr][nc] = dp[temp.row][temp.col] + arr[nr][nc];
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}
}
