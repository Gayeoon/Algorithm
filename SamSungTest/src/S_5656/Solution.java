package S_5656;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Point {
	int row, col, val;

	Point(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

public class Solution {
	static int N, W, H;
	static int[][] arr;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static int result = 0;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();

			arr = new int[H][W];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++)
				for (int j = 0; j < W; j++)
					arr[i][j] = sc.nextInt();

			solve(0);
			if(result == Integer.MAX_VALUE)
				sb.append("#" + test_case + " " +0+ "\n");
			else
				sb.append("#" + test_case + " " +result+ "\n");
		}
		System.out.print(sb);
	}

	static void solve(int n) {
		if (n == N) {
			result = Math.min(result, countMap());
			return;
		}
		for (int j = 0; j < W; j++) {
			int tmp = deep(j);
			if (tmp < 0)
				continue;
			int tempMap[][] = new int[H][W];
			for (int a = 0; a < H; a++)
				for (int b = 0; b < W; b++)
					tempMap[a][b] = arr[a][b];
			
			breakWall(tmp, j);
			downWall();
			solve(n + 1);

			for (int a = 0; a < H; a++)
				for (int b = 0; b < W; b++)
					arr[a][b] = tempMap[a][b];
		}
	}

	static int countMap() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	static void downWall() {
		Stack<Integer> stack = new Stack<>();
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (arr[i][j] != 0) {
					stack.add(arr[i][j]);
					arr[i][j] = 0;
				}
			}
			int idx = H - 1;
			while (true) {
				if (stack.isEmpty())
					break;
				arr[idx--][j] = stack.pop();
			}
		}
	}

	static void breakWall(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col, arr[row][col]));
		arr[row][col] = 0;
		
		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();
			for (int i = 1; i < tmp.val; i++) {
				for (int j = 0; j < 4; j++) {
					int nr = tmp.row + i * Dr[j];
					int nc = tmp.col + i * Dc[j];

					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;
					if (arr[nr][nc] == 0)
						continue;
					if (arr[nr][nc] != 1)
						queue.add(new Point(nr, nc, arr[nr][nc]));
					arr[nr][nc] = 0;
				}
			}
		}
	}

	static int deep(int col) {
		for (int i = 0; i < H; i++) {
			if (arr[i][col] != 0)
				return i;
		}
		return -1;
	}
}