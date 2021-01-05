package B_1926;

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
	static int arr[][];
	static int N, M;
	static boolean visit[][];
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		int result = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 || visit[i][j])
					continue;
				max = Math.max(max, solve(i, j));
				result++;
			}
		}

		System.out.println(result);
		System.out.println(max);
	}

	static int solve(int row, int col) {
		int cnt = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		visit[row][col] = true;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (arr[nr][nc] == 1 && !visit[nr][nc]) {
					queue.add(new Point(nr, nc));
					visit[nr][nc] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}

}
