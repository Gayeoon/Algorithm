package LegMaking_2146;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col, num;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int arr[][];
	static int island[][];
	static int dist[][];
	static Queue<Point> queue;
	static int Dr[] = { 1, 0, -1, 0 };
	static int Dc[] = { 0, 1, 0, -1 };
	static final int INF = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		arr = new int[n][n];
		island = new int[n][n];
		dist = new int[n][n];
		queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					makeIsland(cnt, i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(solve());
	}

	static void makeIsland(int cnt, int row, int col) {

		Queue<Point> q = new LinkedList<>();

		queue.add(new Point(row, col));
		q.add(new Point(row, col));
		island[row][col] = cnt;
		arr[row][col] = 0;

		while (true) {
			if (q.isEmpty())
				break;

			Point temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];

				if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
					continue;
				if (arr[nr][nc] == 1) {
					island[nr][nc] = cnt;
					arr[nr][nc] = 0;
					q.add(new Point(nr, nc));
					queue.add(new Point(nr, nc));
				}
			}
		}
	}

	static int solve() {
		int min = INF;
		while (true) {
			if (queue.isEmpty())
				break;

			Point temp = queue.poll();

			if(dist[temp.row][temp.col] >= min) continue;
			for (int i = 0; i < 4; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];

				if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
					continue;

				if (island[nr][nc] == 0) {
					island[nr][nc] = island[temp.row][temp.col];
					queue.add(new Point(nr, nc));
					dist[nr][nc] = dist[temp.row][temp.col] + 1;
				}else if(island[nr][nc] != island[temp.row][temp.col]) {
					dist[nr][nc] = dist[nr][nc] + dist[temp.row][temp.col];
					min = Math.min(min, dist[nr][nc]);
				}
			}

		}
		return min;
	}
}
