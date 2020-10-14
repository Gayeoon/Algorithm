package SW_17086;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col, time;

	Point(int row, int col, int time) {
		this.row = row;
		this.col = col;
		this.time = time;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		int arr[][] = new int[n][m];
		int dp[][] = new int[n][m];

		int Dr[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
		int Dc[] = { -1, -1, 0, 1, 1, 1, 0 , -1};
		Queue<Point> queue = new LinkedList<>();
		boolean visit[][] = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] == 1) {
					queue.add(new Point(i, j, 0));
					visit[i][j] = true;
				}
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] == 1)
					continue;

				if (!visit[nr][nc] || dp[nr][nc] > tmp.time + 1) {
					visit[nr][nc] = true;
					dp[nr][nc] = tmp.time + 1;
					queue.add(new Point(nr, nc, tmp.time + 1));
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1)
					continue;
				result = Math.max(result, dp[i][j]);
			}
		}
		
		System.out.println(result);

	}

}
