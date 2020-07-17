package B_1194;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, cnt, key;

	Point(int row, int col, int key, int cnt) {
		this.row = row;
		this.col = col;
		this.key = key;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Point p) {
		if (this.cnt < p.cnt)
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

		char maze[][] = new char[n][m];
		boolean visit[][][] = new boolean[n][m][64];
		PriorityQueue<Point> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			String str = input.next();
			if (str.contains("0")) {
				for (int j = 0; j < m; j++) {
					maze[i][j] = str.charAt(j);
					if (maze[i][j] == '0') {
						queue.add(new Point(i, j, 0, 0));
					}
				}
			} else
				maze[i] = str.toCharArray();
		}

		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };
		int min = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (maze[tmp.row][tmp.col] == '1') {
				min = Math.min(min, tmp.cnt);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;

				if (visit[nr][nc][tmp.key] || maze[nr][nc] == '#')
					continue;

				if (maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') {
					int newKey = tmp.key;
					int check = 1 << (maze[nr][nc] - 'a');
					if ((tmp.key & check) != check)
						newKey = tmp.key | check;
					visit[nr][nc][newKey] = true;
					queue.add(new Point(nr, nc, newKey, tmp.cnt + 1));
				} else if (maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
					int check = 1 << (maze[nr][nc] - 'a');
					if ((tmp.key & check) == check) {
						visit[nr][nc][tmp.key] = true;
						queue.add(new Point(nr, nc, tmp.key, tmp.cnt + 1));
					}
				} else {
					visit[nr][nc][tmp.key] = true;
					queue.add(new Point(nr, nc, tmp.key, tmp.cnt + 1));
				}
			}
		}

		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
