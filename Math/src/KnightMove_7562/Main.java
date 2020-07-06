package KnightMove_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int arr[][];
	static int dp[][];
	static boolean visit[][];
	static int Dr[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int Dc[] = { -2, -1, 1, 2, -2, -1, 1, 2 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = input.nextInt();
			arr = new int[n][n];
			dp = new int[n][n];
			visit = new boolean[n][n];

			int sr = input.nextInt();
			int sc = input.nextInt();
			int er = input.nextInt();
			int ec = input.nextInt();
			int result = solve(sr, sc, er, ec);
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}

	static int solve(int sr, int sc, int er, int ec) {

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sr, sc));
		int min = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();

			if (tmp.row == er && tmp.col == ec) {
				min = Math.min(min, dp[er][ec]);
				continue;
			}

			if (min <= dp[tmp.row][tmp.col])
				continue;

			for (int i = 0; i < 8; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr[0].length)
					continue;

				if (!visit[nr][nc] || dp[nr][nc] > dp[tmp.row][tmp.col] + 1) {
					visit[nr][nc] = true;
					dp[nr][nc] = dp[tmp.row][tmp.col] + 1;
					queue.add(new Point(nr, nc));
				}

			}
		}
		return min;
	}
}
