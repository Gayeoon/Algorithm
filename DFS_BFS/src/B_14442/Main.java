package B_14442;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, val, wall;

	Point(int row, int col, int val, int wall) {
		this.row = row;
		this.col = col;
		this.val = val;
		this.wall = wall;
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
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();

		int map[][] = new int[n][m];
		int dp[][] = new int[n][m];
		boolean visit[][][] = new boolean[n][m][k + 1];

		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 1, 0));
		visit[0][0][0] = true;
		dp[0][0] = 1;
		int min = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.row == n - 1 && tmp.col == m - 1) {
				min = Math.min(min, tmp.val);
				continue;
			}

			if (min <= tmp.val)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				
				int wall = tmp.wall;
				if(map[nr][nc] == 1) {
					if(wall == k)
						continue;
					wall++;
				}
				
				if(!visit[nr][nc][wall] || dp[nr][nc] > dp[tmp.row][tmp.col]+1) {
					visit[nr][nc][wall] =true;
					dp[nr][nc] = dp[tmp.row][tmp.col]+1;
					queue.add(new Point(nr, nc, dp[nr][nc], wall));
				}
			}
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
