package B_2206;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, cnt, move;

	Point(int row, int col, int cnt, int move) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.move = move;
	}

	@Override
	public int compareTo(Point p) {
		if (this.move < p.move)
			return -1;
		else if (this.move == p.move) {
			if (this.cnt < p.cnt)
				return -1;
			else
				return 1;
		} else
			return 1;
	}

}

public class Main {
	static int Dr[] = { 0, -1, 0, 1 };
	static int Dc[] = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		int arr[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '0')
					arr[i][j] = 0;
				else
					arr[i][j] = 1;
			}
		}

		boolean visit[][][] = new boolean[n][m][2];

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 0, 1));
		visit[0][0][0] = true;
		int len = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.row == n - 1 && tmp.col == m - 1) {
				len = Math.min(len, tmp.move);
				continue;
			}

			if (len <= tmp.move)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;

				if (tmp.cnt == 0) {
					if (arr[nr][nc] == 1 && !visit[nr][nc][1]) {
						visit[nr][nc][1] = true;
						queue.add(new Point(nr, nc, 1, tmp.move + 1));
					} else if (arr[nr][nc] == 0 && !visit[nr][nc][0]) {
						visit[nr][nc][0] = true;
						queue.add(new Point(nr, nc, 0, tmp.move + 1));
					}
				} else {
					if (arr[nr][nc] == 0 && !visit[nr][nc][1]) {
						visit[nr][nc][1] = true;
						queue.add(new Point(nr, nc, 1, tmp.move + 1));
					}
				}

			}

		}
		if (len == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(len);
	}

}
