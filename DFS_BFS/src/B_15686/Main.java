package B_15686;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, val;

	Point(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public int compareTo(Point p) {
		if (this.val < p.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int map[][];
	static int chicken[][];
	static int N, res = Integer.MAX_VALUE;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static ArrayList<Point> house = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		int M = input.nextInt();

		map = new int[N][N];
		chicken = new int[N][N];

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = input.nextInt();
				if (map[i][j] == 1)
					house.add(new Point(i, j, 0));
				else if (map[i][j] == 2) {
					chicken[i][j] = cnt;
					cnt++;
				}
			}
		}
		boolean[] check = new boolean[cnt];

		if (M >= cnt) {
			int sum = 0;
			Arrays.fill(check, true);
			for (int i = 0; i < house.size(); i++) {
				int row = house.get(i).row;
				int col = house.get(i).col;
				int result = bfs(row, col, check);
				sum += result;
			}
			System.out.println(sum);
		} else {
			solve(cnt, M, 0, 0, check);
			System.out.println(res);
		}
	}

	static void solve(int n, int r, int idx, int cnt, boolean[] check) {
		if (cnt == r) {
			System.out.println();
			for(int i=0; i<check.length; i++)
				System.out.print(check[i]+" ");
			System.out.println();
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				if (sum >= res)
					break;
				int row = house.get(i).row;
				int col = house.get(i).col;
				int result = bfs(row, col, check);
				sum += result;
			}

			res = Math.min(res, sum);
			return;
		}
		if (idx >= n)
			return;
		check[idx] = true;
		solve(n, r, idx + 1, cnt + 1, check);
		check[idx] = false;
		solve(n, r, idx + 1, cnt, check);
	}

	static int bfs(int row, int col, boolean[] check) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		boolean visit[][] = new boolean[N][N];

		visit[row][col] = true;
		queue.add(new Point(row, col, 0));

		int min = Integer.MAX_VALUE;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (map[tmp.row][tmp.col] == 2 && check[chicken[tmp.row][tmp.col]]) {
				if (tmp.val < min) {
					min = tmp.val;

				}
				continue;
			}

			if (min <= tmp.val)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (visit[nr][nc])
					continue;

				visit[nr][nc] = true;

				queue.add(new Point(nr, nc, tmp.val + 1));
			}
		}
		return min;
	}

}
