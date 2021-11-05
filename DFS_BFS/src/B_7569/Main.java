package B_7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int m, n, h;

	Point(int n, int m, int h) {
		this.n = n;
		this.m = m;
		this.h = h;
	}
}

public class Main {

	static int[][][] box;
	static int m, n, h;
	static int[] Dr = { -1, 1, 0, 0, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1, 0, 0 };
	static int[] Dh = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		m = input.nextInt();
		n = input.nextInt();
		h = input.nextInt();
		box = new int[n][m][h];
		Queue<Point> queue = new LinkedList<>();

		int count = 0, sum = m*n*h;

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					box[i][j][k] = input.nextInt();
					if (box[i][j][k] == 1) {
						queue.add(new Point(i, j, k));
						count++;
					}
					else if(box[i][j][k] == -1)
						sum--;
				}
			}
		}

		int day = 0;
		
		while (true) {
			if (count == sum) {
				System.out.println(day);
				break;
			}
			if (queue.isEmpty()) {
				System.out.println(-1);
				break;
			}

			queue = bfs(queue);
			count += queue.size();
			day++;
		}
	}

	static Queue<Point> bfs(Queue<Point> queue) {
		Queue<Point> newQueue = new LinkedList<>();

		while (true) {
			if (queue.isEmpty())
				break;

			Point point = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nr = point.n + Dr[i];
				int nc = point.m + Dc[i];
				int nh = point.h + Dh[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || nh < 0 || nh >= h || box[nr][nc][nh] == -1
						|| box[nr][nc][nh] == 1)
					continue;

				newQueue.add(new Point(nr, nc, nh));
				box[nr][nc][nh] = 1;
			}
		}

		return newQueue;
	}
}
