package B_2178_V2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, dist;

	Point(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}

	@Override
	public int compareTo(Point p) {
		if (this.dist <= p.dist)
			return -1;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		int arr[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str[] = input.next().split("");
			arr[i] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 1));

		boolean visit[][] = new boolean[N][M];
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };

		while (true) {
			if (queue.isEmpty())
				break;

			Point temp = queue.poll();

			if (temp.row == N - 1 && temp.col == M - 1) {
				System.out.println(temp.dist);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || arr[nr][nc] == 0)
					continue;

				visit[nr][nc] = true;
				queue.add(new Point(nr, nc, temp.dist + 1));
			}
		}
	}

}
