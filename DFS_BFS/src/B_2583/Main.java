package B_2583;

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
	static boolean[][] area;
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();

		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();

		area = new boolean[n][m];

		for (int i = 0; i < k; i++) {
			int start_col = input.nextInt();
			int start_row = input.nextInt();
			int end_col = input.nextInt();
			int end_row = input.nextInt();

			for (int r = start_row; r < end_row; r++) {
				for (int c = start_col; c < end_col; c++) {
					area[r][c] = true;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (area[i][j])
					continue;
				list.add(solve(i, j));
			}
		}

		if (list.size() == 0)
			System.out.print(0);
		else {
			list.sort(null);
			System.out.println(list.size());
			for (int i : list)
				System.out.print(i + " ");
		}
	}

	static int solve(int row, int col) {

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		area[row][col] = true;
		int cnt = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= area.length || nc >= area[0].length)
					continue;
				if (area[nr][nc])
					continue;

				area[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
		return cnt;
	}

}
