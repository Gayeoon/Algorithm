package B_3187;

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
	static char[][] area;
	static boolean[][] visit;
	static int n, m;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static int sheep = 0, wolf = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		area = new char[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			area[i] = input.next().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (area[i][j] == '#' || visit[i][j])
					continue;
				solve(i, j);
			}
		}

		System.out.print(sheep + " " + wolf);
	}

	static void solve(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		visit[row][col] = true;

		int v = 0, k = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (area[tmp.row][tmp.col] == 'v')
				v++;
			else if (area[tmp.row][tmp.col] == 'k')
				k++;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (visit[nr][nc] || area[nr][nc] == '#')
					continue;

				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));

			}
		}

		if (v < k)
			sheep += k;
		else
			wolf += v;
	}
}
