package S_1953;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Point {
	int row, col, time;

	Point(int row, int col, int time) {
		this.row = row;
		this.col = col;
		this.time = time;
	}
}

class Solution {
	static int ternel[][] = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 },
			{ 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 } };
	static int Dr[] = { -1, 0, 1, 0 };
	static int Dc[] = { 0, 1, 0, -1 };
	static int arr[][];
	static int dir[] = { 2, 3, 0, 1 };

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();

			arr = new int[N][M];

			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					arr[i][j] = sc.nextInt();

			sb.append("#" + test_case + " " + solve(R, C, L, N, M) + "\n");
		}
		System.out.print(sb);
	}

	static int solve(int row, int col, int L, int N, int M) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col, 1));
		boolean visit[][] = new boolean[N][M];
		visit[row][col] = true;
		int cnt = 1;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.time >= L)
				continue;
			int idx = arr[tmp.row][tmp.col];
			for (int i = 0; i < 4; i++) {
				if (ternel[idx][i] == 0)
					continue;
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visit[nr][nc])
					continue;
				if (check(nr, nc, dir[i])) {
					queue.add(new Point(nr, nc, tmp.time + 1));
					visit[nr][nc] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	static boolean check(int row, int col, int dir) {
		if (arr[row][col] == 0)
			return false;

		if (ternel[arr[row][col]][dir] == 0)
			return false;

		return true;
	}
}