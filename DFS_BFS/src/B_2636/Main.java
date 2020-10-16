package B_2636;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int row, col;

	Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int n, m;
	static int arr[][];
	static boolean visit[][];
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		arr = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		int time = 0;

		int prev = 0;
		while (true) {
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], false);
			}

			// 치즈 개수 세기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 & !visit[i][j]) {
						cnt += count(i, j);
					}
				}
			}

			if (cnt == 0) {
				System.out.println(time);
				System.out.println(prev);
				break;
			}

			prev = cnt;

			// 녹이기
			solve();
			
			time++;
		}
	}

	static int count(int row, int col) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(row, col));
		visit[row][col] = true;
		
		int result = 1;
		while (true) {
			if (queue.isEmpty())
				break;

			Pair tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc])
					continue;

				if (arr[nr][nc] == 1) {
					queue.add(new Pair(nr, nc));
					result++;
					visit[nr][nc] = true;
				}
			}
		}
		return result;
	}

	static void solve() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0));
		boolean visited[][] = new boolean[n][m];
		visited[0][0] = true;

		while (true) {
			if (queue.isEmpty())
				break;

			Pair tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc])
					continue;

				visited[nr][nc] = true;

				if (arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
				} else {
					queue.add(new Pair(nr, nc));
				}
			}
		}
	}

}
