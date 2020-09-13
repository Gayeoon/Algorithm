package Test2_4;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Solution {

	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };
	static int dir[] = { 2, 3, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] maze = { { 0, 1, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		boolean visit[][] = new boolean[maze.length][maze[0].length];
		int dp[][] = new int[maze.length][maze[0].length];

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visit[0][0] = true;

		int min = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();

			if (tmp.row == maze.length - 1 && tmp.col == maze[0].length - 1) {
				min = Math.min(min, dp[tmp.row][tmp.col]);
				continue;
			}

			if (min <= dp[tmp.row][tmp.col])
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= maze.length || nc < 0 || nc >= maze[0].length)
					continue;
				if (maze[nr][nc] == 1)
					continue;
				if (!wall(i, nr, nc, maze))
					continue;

				if (!visit[nr][nc] || dp[nr][nc] > dp[tmp.row][tmp.col] + maze[nr][nc]) {
					visit[nr][nc] = true;
					dp[nr][nc] = dp[tmp.row][tmp.col] + maze[nr][nc];
					queue.offer(new Point(nr, nc));
				}
			}

		}

		System.out.println(min);
	}

	static boolean wall(int now_dir, int row, int col, int[][] maze) {
		int nr = row + Dr[dir[now_dir]];
		int nc = col + Dc[dir[now_dir]];

		if (nr < 0 || nr >= maze.length || nc < 0 || nc >= maze[0].length)
			return true;
		if (maze[nr][nc] == 1)
			return true;

		return false;
	}
}