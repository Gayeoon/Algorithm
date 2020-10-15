package SW_17142;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col, time;

	Point(int row, int col, int time) {
		this.row = row;
		this.col = col;
		this.time = time;
	}
}

public class Main {
	static int[][] arr;
	static LinkedList<Point> virus;
	static boolean visit[];
	static int n, m;
	static int result = Integer.MAX_VALUE;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		arr = new int[n][n];
		virus = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] == 2)
					virus.add(new Point(i, j, 0));
			}
		}

		visit = new boolean[virus.size()];
		
		solve(0, 0);
		if(result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}

	static void solve(int idx, int cnt) {
		if (cnt == m) {
			result = Math.min(result, moveVirus());
			return;
		}
		if (idx >= virus.size())
			return;

		visit[idx] = true;
		solve(idx + 1, cnt + 1);
		visit[idx] = false;
		solve(idx + 1, cnt);
	}

	static int moveVirus() {
		Queue<Point> queue = new LinkedList<>();
		boolean visited[][] = new boolean[n][n];
		int dp[][] = new int[n][n];
		for (int i = 0; i < virus.size(); i++) {
			if (visit[i]) {
				queue.add(virus.get(i));
				visited[virus.get(i).row][virus.get(i).col] = true;
			}
		}

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] == 1)
					continue;

				if (!visited[nr][nc] || dp[nr][nc] > tmp.time + 1) {
					visited[nr][nc] = true;
					dp[nr][nc] = tmp.time + 1;
					queue.add(new Point(nr, nc, tmp.time + 1));
				}
			}
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > 0)
					continue;
				if (!visited[i][j])
					return Integer.MAX_VALUE;
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}
}
