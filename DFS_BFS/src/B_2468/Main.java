package B_2468;

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
	static int area[][];
	static boolean visit[][];
	static int[] Dr = {-1, 1, 0, 0};
	static int[] Dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		area = new int[n][n];

		int idx = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				area[i][j] = input.nextInt();
				idx = Math.max(idx, area[i][j]);
			}
		}
		int max = 0;
		
		for (int k = 0; k <= idx; k++) {
			visit = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (area[i][j] <= k || visit[i][j])
						continue;
					solve(i, j, k);
					cnt++;
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}

	static void solve(int row, int col, int k) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		visit[row][col] = true;
		while(true) {
			if(queue.isEmpty()) break;
			Point tmp = queue.poll();
			
			for(int t=0; t<4; t++) {
				int nr = tmp.row + Dr[t];
				int nc = tmp.col + Dc[t];
				
				if(nr < 0 || nc < 0 || nr >= area.length || nc >= area[0].length) continue;
				
				if(!visit[nr][nc] && area[nr][nc] > k) {
					visit[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
	}

}
