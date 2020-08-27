package B_2234;

import java.util.HashMap;
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
	static int[][] room;
	static int[][] roomIdx;
	static boolean visit[][];
	static HashMap<Integer, Integer> hash = new HashMap<>();
	static int Dr[] = { 0, -1, 0, 1 };
	static int Dc[] = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int m = input.nextInt();
		int n = input.nextInt();

		room = new int[n][m];
		roomIdx = new int[n][m];

		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				room[i][j] = input.nextInt();
			}
		}

		int idx = 1;
		int max_idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j])
					continue;
				int count = bfs(i, j, idx);
				hash.put(idx, count);

				if (max_idx == 0) {
					max_idx = idx;
				} else if (hash.get(max_idx) < count) {
					max_idx = idx;
				}

				idx++;
			}
		}

		System.out.println(idx - 1);
		System.out.println(hash.get(max_idx));

		int max = 0;
		boolean check[] = new boolean[idx];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[roomIdx[i][j]])
					continue;
				visit = new boolean[n][m];
				int tmp = solve(i, j, roomIdx[i][j]);
				max = Math.max(max, tmp);
				check[roomIdx[i][j]] = true;
			}
		}

		System.out.println(max);

	}

	static int solve(int row, int col, int idx) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));

		visit[row][col] = true;
		boolean check[] = new boolean[hash.size() + 1];

		int max = 0;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= visit.length || nc < 0 || nc >= visit[0].length)
					continue;

				if (visit[nr][nc] || check[roomIdx[nr][nc]])
					continue;

				if (roomIdx[nr][nc] == idx) {
					visit[nr][nc] = true;
					queue.add(new Point(nr, nc));
				} else {
					check[roomIdx[nr][nc]] = true;
					max = Math.max(max, hash.get(idx) + hash.get(roomIdx[nr][nc]));
				}
			}

		}

		return max;
	}

	static int bfs(int row, int col, int idx) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));

		visit[row][col] = true;
		int cnt = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			cnt++;
			roomIdx[tmp.row][tmp.col] = idx;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= visit.length || nc < 0 || nc >= visit[0].length)
					continue;

				if (visit[nr][nc] || (room[tmp.row][tmp.col] & (1 << i)) != 0)
					continue;
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}

		}

		return cnt;
	}

}
