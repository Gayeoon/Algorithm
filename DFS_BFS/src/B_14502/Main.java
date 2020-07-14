package B_14502;

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
	static int[][] map;
	static LinkedList<Point> list;
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		map = new int[n][m];
		list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = input.nextInt();
				if (map[i][j] == 2) {
					list.add(new Point(i, j));
				}
			}
		}

		solve(0,0,0);
		System.out.println(max);
	}

	static void solve(int row, int col, int cnt) {
		if (cnt == 3) {
			max = Math.max(max, virus());
			return;
		}

		if (col >= map[0].length) {
			solve(row + 1, 0, cnt);
			return;
		}

		if(row >= map.length) 
			return;
		
		if (map[row][col] == 0) {
			map[row][col] = 1;
			solve(row, col + 1, cnt + 1);
			map[row][col] = 0;
		} 
		
		solve(row, col + 1, cnt);
		
	}

	static int virus() {
		boolean[][] visit = new boolean[map.length][map[0].length];
		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };
		
		Queue<Point> queue = new LinkedList<>();
		for(Point p : list) {
			queue.add(p);
			visit[p.row][p.col] = true;
		}
		
		while (true) {
			if (queue.isEmpty())
				break;

			Point temp = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length)
					continue;
				if(!visit[nr][nc] && map[nr][nc] == 0) {
					visit[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
		
		return check(visit);
	}
	
	static int check(boolean[][] visit) {
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(!visit[i][j] && map[i][j] != 1)
					cnt++;
			}
		}
		return cnt;
	}
}
