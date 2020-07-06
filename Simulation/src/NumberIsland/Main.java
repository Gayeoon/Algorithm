package NumberIsland;

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
	static int[][] arr;
	static int[] Dr = { -1, 1, 0, 0, -1 , -1, 1, 1};
	static int[] Dc = { 0, 0, -1, 1, -1, 1 , -1, 1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int w = input.nextInt();
			int h = input.nextInt();

			if (w == 0 && h == 0)
				break;
			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = input.nextInt();
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						solve(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt + "\n");
		}
		System.out.print(sb);
	}

	static void solve(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		arr[row][col] = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Point temp = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];

				if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
					continue;

				if (arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					queue.add(new Point(nr, nc));
				}

			}

		}
	}
}
