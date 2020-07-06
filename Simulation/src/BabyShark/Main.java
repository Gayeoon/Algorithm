package BabyShark;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Dot implements Comparable<Dot> {
	int row, col, size, dist;

	Dot(int row, int col, int size, int dist) {
		this.row = row;
		this.col = col;
		this.size = size;
		this.dist = dist;
	}

	@Override
	public int compareTo(Dot d) {
		if (this.dist < d.dist)
			return -1;
		else if (this.dist == d.dist) {
			if (this.row < d.row)
				return -1;
			else if (this.row == d.row) {
				if (this.col < d.col)
					return -1;
				else
					return 1;
			} else
				return 1;
		} else
			return 1;
	}
}

public class Main {

	static Dot shark;
	static int[][] bowl;
	static int[][] dis;
	static boolean[][] visit;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		bowl = new int[N][N];
		dis = new int[N][N];
		visit = new boolean[N][N];
		int time = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = input.nextInt();
				bowl[i][j] = temp;
				if (temp == 9) {
					shark = new Dot(i, j, 2, 0);
				}
			}
		}
		int count = 0;
		boolean flag = false;
		while (true) {
			for (int k = 0; k < N; k++) {
				Arrays.fill(dis[k], Integer.MAX_VALUE);
				Arrays.fill(visit[k], false);
			}
			PriorityQueue<Dot> queue = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bowl[i][j] != 0 && bowl[i][j] < shark.size) {
						int d = find(shark, i, j, 0);
						if (d == Integer.MAX_VALUE)
							flag = true;
						queue.add(new Dot(i, j, bowl[i][j], d));
					}
				}
			}
			if (flag)
				break;
			Dot temp = queue.poll();
			bowl[temp.row][temp.col] = bowl[shark.row][shark.col] = 0;
			count++;

			if (count == shark.size)
				shark = new Dot(temp.row, temp.col, shark.size + 1, shark.dist + temp.dist);
			else
				shark = new Dot(temp.row, temp.col, shark.size, shark.dist + temp.dist);

			if (check())
				break;
		}

		System.out.println(shark.dist);

	}

	static int find(Dot target, int row, int col, int dist) {
		if (row == target.row && col == target.col)
			return dist;
		else {
			if (visit[row][col])
				return dist;
			visit[row][col] = true;
			int[] Dr = { -1, 0, 1, 0 };
			int[] Dc = { 0, -1, 0, 1 };
			for (int i = 0; i < 4; i++) {
				int nr = row + Dr[i];
				int nc = col + Dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
					continue;
				if (bowl[nr][nc] != 9 && bowl[nr][nc] > target.size)
					continue;
				dis[row][col] = Math.min(dis[row][col], find(target, nr, nc, dist + 1));
			}
		}
		return dis[target.row][target.col];
	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (bowl[i][j] == 9)
					continue;
				if (bowl[i][j] != 0)
					return false;
			}
		}
		return true;
	}
}
