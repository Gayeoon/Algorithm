package B_10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col;
	char color;

	Point(int row, int col, char color) {
		this.row = row;
		this.col = col;
		this.color = color;
	}
}

public class Main {
	static int N;
	static char arr[][];

	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	static boolean visit[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = input.next();
			arr[i] = str.toCharArray();
		}

		int cnt = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				solve(i, j, false);
				cnt++;
			}
		}
		System.out.print(cnt + " ");

		cnt = 0;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				solve(i, j, true);
				cnt++;
			}
		}
		System.out.print(cnt);
	}

	static void solve(int row, int col, boolean type) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col, arr[row][col]));
		visit[row][col] = true;

		while (!queue.isEmpty()) {
			Point tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (check(nr, nc, type, tmp.color))
					continue;

				visit[nr][nc] = true;
				queue.add(new Point(nr, nc, arr[nr][nc]));
			}
		}
	}

	static boolean check(int row, int col, boolean type, char color) {
		if (row < 0 || row >= N || col < 0 || col >= N || visit[row][col])
			return true;

		if (type) {
			if (color == 'B' && arr[row][col] == 'B')
				return false;
			else if (color != 'B' && arr[row][col] != 'B')
				return false;
			return true;
		}

		else {
			if (color == arr[row][col])
				return false;
			else
				return true;
		}
	}
}
