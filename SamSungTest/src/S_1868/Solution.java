package S_1868;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Solution {
	static int[] Dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] Dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static char[][] arr;
	static int[][] pop;
	static boolean[][] visited;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			arr = new char[n][n];
			pop = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == '*') {
						pop[i][j] = -1;
						continue;
					}
					pop[i][j] = count(i, j);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (pop[i][j] != 0 || visited[i][j]) 
						continue;
					
					check(i, j);
					cnt++;
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (pop[i][j] == -1 || visited[i][j]) 
						continue;
					cnt++;
				}
			}
			
			sb.append("#" + test_case + " " + cnt + "\n");
		}
		System.out.print(sb);
	}
	
	static int count(int row, int col) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
				continue;
			if (arr[nr][nc] == '*')
				cnt++;
		}
		return cnt;
	}

	static void check(int row, int col) {
		visited[row][col] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));

		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
					continue;
				if (pop[nr][nc] == -1 || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				if(pop[nr][nc] == 0)
					queue.add(new Point(nr, nc));
			}
			
		}
	}
}