package B_2665;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, val;

	Point(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public int compareTo(Point p) {
		if (this.row > p.row)
			return -1;
		else if (this.row == p.row) {
			if (this.col > p.col)
				return -1;
			else if (this.col == p.col) {
				if (this.val < p.val)
					return -1;
			}
		}
		return 1;
	}
}

public class Main {
	static final int INF = 987654321;
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[][] = new int[n][n];
		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = input.next();

			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
			Arrays.fill(dp[i], INF);
		}

		int result = INF;

		PriorityQueue<Point> queue = new PriorityQueue<>();
		dp[0][0] = 0;
		queue.add(new Point(0, 0, 0));

		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();

			if (tmp.row == n - 1 && tmp.col == n - 1) {
				result = Math.min(result, tmp.val);
			}

			if (result <= tmp.val)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;

				int val = tmp.val;

				if (arr[nr][nc] == 0)
					val++;

				if (dp[nr][nc] > val) {
					dp[nr][nc] = val;
					queue.add(new Point(nr, nc, val));
				}
			}
		}
		
		System.out.println(result);
	}

}
