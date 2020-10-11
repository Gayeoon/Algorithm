package B_2573;

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
	static int n, m;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static boolean visit[][];
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		arr = new int[n][m];
		
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] != 0)
					queue.add(new Point(i, j));
			}
		}
		
		int time = 0;
		
		while(true) {
			if(count() >= 2)
				break;
			if(queue.size() <= 1) {
				time = 0;
				break;
			}
			queue = minus(queue);
			time++;
		}
		
		System.out.print(time);
	}

	static int count() {
		visit = new boolean[n][m];
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] !=0 && !visit[i][j]) {
					Island(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void Island(int row, int col) {
		visit[row][col] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (arr[nr][nc] == 0 || visit[nr][nc])
					continue;
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
	}
	
	static Queue<Point> minus(Queue<Point> queue){
		Queue<Point> q = new LinkedList<>();
		boolean visited[][] = new boolean[n][m];
		
		while(true) {
			if(queue.isEmpty())
				break;
			
			int row = queue.peek().row;
			int col = queue.poll().col;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = row + Dr[i];
				int nc = col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (arr[nr][nc] == 0 && !visited[nr][nc])
					cnt++;
			}
			if (arr[row][col] - cnt <= 0)
				arr[row][col] = 0;
			else
				arr[row][col] = arr[row][col] - cnt;

			if (arr[row][col] != 0)
				q.add(new Point(row, col));
			visited[row][col] = true;
		}
		return q;
	}
}
