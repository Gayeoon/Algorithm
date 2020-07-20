package B_1600;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {

	int row, col, val, cnt;

	Point(int row, int col, int val, int cnt) {
		this.row = row;
		this.col = col;
		this.val = val;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Point p) {
		if (this.val < p.val)
			return -1;
		else
			return 1;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int m = input.nextInt();
		int n = input.nextInt();

		int[][] arr = new int[n][m];
		boolean[][][] visit = new boolean[n][m][k + 1];
		int[][] dp = new int[n][m];

		int Dr[] = { -2, -1, 1, 2, 2, 1, -1, -2, -1, 1, 0, 0 };
		int Dc[] = { 1, 2, 2, 1, -1, -2, -2, -1, 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 0, 0));
		visit[0][0][0] = true;

		int min = Integer.MAX_VALUE;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.row == n - 1 && tmp.col == m - 1) {
				min = Math.min(min, dp[tmp.row][tmp.col]);
				continue;
			}

			if (tmp.val >= min)
				continue;

			for (int i = 0; i < 12; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (arr[nr][nc] == 1)
					continue;

				int cnt = tmp.cnt;
				if (i < 8) {
					if (cnt < k)
						cnt++;
					else
						continue;
				}
				if (!visit[nr][nc][cnt] || dp[nr][nc] > dp[tmp.row][tmp.col] + 1) {
					visit[nr][nc][cnt] = true;
					dp[nr][nc] = dp[tmp.row][tmp.col] + 1;
					queue.add(new Point(nr, nc, dp[nr][nc], cnt));
				}
			}
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
