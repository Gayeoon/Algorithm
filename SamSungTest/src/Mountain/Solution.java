package Mountain;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;

class Mountain implements Comparable<Mountain> {
	int row, col, height;

	Mountain(int row, int col, int height) {
		this.row = row;
		this.col = col;
		this.height = height;
	}

	@Override
	public int compareTo(Mountain m) {
		if (this.height >= m.height)
			return -1;
		else
			return 1;
	}
}

public class Solution {
	static int[][] arr;
	static boolean[][] visit;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			arr = new int[n][n];

			PriorityQueue<Mountain> queue = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					queue.add(new Mountain(i, j, arr[i][j]));
				}
			}
			int maxHeight = queue.peek().height;
			int max = 0;
			while (true) {
				if (queue.isEmpty())
					break;
				if (maxHeight > queue.peek().height)
					break;
				Mountain tmp = queue.poll();
				visit = new boolean[n][n];
				visit[tmp.row][tmp.col] = true;
				max = Math.max(max, dfs(tmp.row, tmp.col, k, true));
				visit[tmp.row][tmp.col] = false;

			}
			answer[test_case - 1] = max;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static int dfs(int row, int col, int k, boolean flag) {

		int max = 0;
		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];
			if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
				continue;
			if (visit[nr][nc])
				continue;
			if (arr[row][col] > arr[nr][nc]) {
				visit[nr][nc] = true;
				max = Math.max(max, dfs(nr, nc, k, flag) + 1);
				visit[nr][nc] = false;
				check = true;
			} else if (flag && arr[nr][nc] - arr[row][col] < k) {
				visit[nr][nc] = true;
				int tmp = arr[nr][nc];
				arr[nr][nc] = arr[nr][nc] - (arr[nr][nc] - arr[row][col]) - 1;
				max = Math.max(max, dfs(nr, nc, k, false) + 1);
				arr[nr][nc] = tmp;
				visit[nr][nc] = false;
				check = true;
			}
		}
		if (!check) {
			return 1;
		}
		return max;
	}
}