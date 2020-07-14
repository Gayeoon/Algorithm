package B_2178;

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
	public static void main(String[] args) {
		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		int[][] arr = new int[N][M];
		int[][] dp = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = input.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		int min = Integer.MAX_VALUE;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visit[0][0] = true;
		dp[0][0] = 1;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.row == N - 1 && tmp.col == M - 1) {
				min = Math.min(min, dp[tmp.row][tmp.col]);
				continue;
			}

			if (dp[tmp.row][tmp.col] >= min)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if(arr[nr][nc] == 0) continue;
				
				if (!visit[nr][nc] || dp[nr][nc] > dp[tmp.row][tmp.col] + 1) {
					dp[nr][nc] = dp[tmp.row][tmp.col] + 1;
					queue.add(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
		
		System.out.println(min);
	}

}
