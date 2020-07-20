package B_1445;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {

	int row, col, garbage, next;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	Point(int row, int col, int garbage, int next) {
		this.row = row;
		this.col = col;
		this.garbage = garbage;
		this.next = next;
	}

	@Override
	public int compareTo(Point p) {
		if (this.garbage < p.garbage)
			return -1;
		else if (this.garbage == p.garbage) {
			if (this.next < p.next)
				return -1;
			else
				return 1;
		} else
			return 1;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		char arr[][] = new char[n][m];
		boolean visit[][] = new boolean[n][m];
		Point flower = null, start = null;
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };

		ArrayList<Point> list = new ArrayList<>();
		Point dp[][] = new Point[n][m];

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'F')
					flower = new Point(i, j);
				else if (arr[i][j] == 'S')
					start = new Point(i, j);
				else if (arr[i][j] == 'g')
					list.add(new Point(i, j));
			}
		}

		for (Point p : list) {
			for (int i = 0; i < 4; i++) {
				int nr = p.row + Dr[i];
				int nc = p.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;

				if (arr[nr][nc] == '.')
					arr[nr][nc] = 'n';
			}
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(start.row, start.col, 0, 0));
		visit[start.row][start.col] = true;
		dp[start.row][start.col] = new Point(0, 0);

		Point min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.row == flower.row && tmp.col == flower.col) {
				if (min.row > dp[tmp.row][tmp.col].row)
					min = dp[tmp.row][tmp.col];
				else if (min.row == dp[tmp.row][tmp.col].row) {
					if (min.col > dp[tmp.row][tmp.col].col)
						min = dp[tmp.row][tmp.col];
				}
				continue;
			}

			if (min.row < tmp.garbage)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (visit[nr][nc])
					continue;

				if (arr[nr][nc] == 'g') {
					if (!visit[nr][nc] || dp[nr][nc]
							.compareTo(new Point(dp[tmp.row][tmp.col].row + 1, dp[tmp.row][tmp.col].col)) > 0) {
						dp[nr][nc] = new Point(dp[tmp.row][tmp.col].row + 1, dp[tmp.row][tmp.col].col);
						queue.add(new Point(nr, nc, dp[nr][nc].row, dp[nr][nc].col));
					}
				} else if (arr[nr][nc] == 'n') {
					if (!visit[nr][nc] || dp[nr][nc]
							.compareTo(new Point(dp[tmp.row][tmp.col].row, dp[tmp.row][tmp.col].col + 1)) > 0) {
						dp[nr][nc] = new Point(dp[tmp.row][tmp.col].row, dp[tmp.row][tmp.col].col + 1);
						queue.add(new Point(nr, nc, dp[nr][nc].row, dp[nr][nc].col));
					}
				} else {
					if (!visit[nr][nc] || dp[nr][nc]
							.compareTo(dp[tmp.row][tmp.col]) > 0) {
						dp[nr][nc] = dp[tmp.row][tmp.col];
						queue.add(new Point(nr, nc, dp[nr][nc].row, dp[nr][nc].col));
					}
				}
				visit[nr][nc] = true;
			}
		}
		
		
		
		
		System.out.println(min.row +" "+min.col);
	}

}
