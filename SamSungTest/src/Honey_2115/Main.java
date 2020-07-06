package Honey_2115;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;

class Honey implements Comparable<Honey> {
	int row, col, val;

	Honey(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public int compareTo(Honey h) {
		if (this.val >= h.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int[] answer = new int[T];

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int c = sc.nextInt();

			int arr[][] = new int[n][n];
			PriorityQueue<Honey> queue = new PriorityQueue<Honey>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					if (j >= m - 1) {
						int sum = 0;
						sum = solve(arr, i, j, j-m, c, 0, 0);
						
						queue.add(new Honey(i, j, sum));
					} else {
						int tmp = 0;
						int sum = 0;
						for (int k = j; k >= 0; k--) {
							if (tmp + arr[i][k] <= c) {
								tmp += arr[i][k];
								sum += arr[i][k] * arr[i][k];
							}
						}
						queue.add(new Honey(i, m - 1, sum));
					}
				}
			}
			boolean visit[][] = new boolean[n][n];
			int count = 0;
			int result = 0;
			while (true) {
				if (count == 2)
					break;
				Honey temp = queue.poll();
				boolean flag = true;
				for (int i = temp.col; i > temp.col - m; i--) {
					if (visit[temp.row][i]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int i = temp.col; i > temp.col - m; i--) {
						visit[temp.row][i] = true;
					}
					result += temp.val;
					count++;
				}
			}
			answer[test_case - 1] = result;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}
	static int solve(int[][] arr, int row, int start, int end, int c, int sum, int result) {
		if(start == end)
			return result;
		int max = Integer.MIN_VALUE;
		if(sum + arr[row][start] <= c)
			max = Math.max(max, solve(arr, row, start-1, end, c, sum + arr[row][start], result + (arr[row][start] * arr[row][start])));
		
		max = Math.max(max, solve(arr, row, start-1, end, c, sum, result));
		
		return max;
	}
}