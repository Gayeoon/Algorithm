package B_4179;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col, time, type;

	Point(int row, int col, int time, int type) {
		this.row = row;
		this.col = col;
		this.time = time;
		this.type = type;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		char[][] maze = new char[n][m];
		boolean visit[][] = new boolean[n][m];
		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };

		Queue<Point> queue = new LinkedList<>();
		Point jihun = null;

		for (int i = 0; i < n; i++) {
			String str = input.next();
			if (str.contains("J") || str.contains("F")) {
				for (int j = 0; j < m; j++) {
					maze[i][j] = str.charAt(j);
					if (maze[i][j] == 'J') {
						jihun = new Point(i, j, 0, 1);
						visit[i][j] = true;
					} else if (maze[i][j] == 'F') {
						queue.add(new Point(i, j, 0, 0));
					}
				}
			} else
				maze[i] = str.toCharArray();
		}

		queue.add(jihun);

		int min = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			if (tmp.type == 1 && min <= tmp.time + 1)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
					if (tmp.type == 1)
						min = Math.min(min, tmp.time + 1);
					continue;
				}
				if (visit[nr][nc] || maze[nr][nc] == 'F' || maze[nr][nc] == '#')
					continue;

				visit[nr][nc] = true;
				queue.add(new Point(nr, nc, tmp.time + 1, tmp.type));
			}
		}

		if (min == Integer.MAX_VALUE)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(min);
	}
}
