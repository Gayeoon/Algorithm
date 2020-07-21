package B_10711;

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
	static int sand[][];
	static Queue<Point> queue;
	static int n, m;
	static int Dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int Dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		sand = new int[n][m];

		queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '.') {
					queue.add(new Point(i, j));
				} else
					sand[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		int cnt = 0;
		while (true) {
			if (solve()) {
				cnt++;
			} else
				break;
		}

		System.out.println(cnt);
	}

	static boolean solve() {
		int size = queue.size();
		boolean flag = false;
		for(int i=0; i<size; i++) {
			Point tmp = queue.poll();
			
			for (int k = 0; k < 8; k++) {
				int nr = tmp.row + Dr[k];
				int nc = tmp.col + Dc[k];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				
				if (sand[nr][nc] == 0)
					continue;
				sand[nr][nc]--;
				if (sand[nr][nc] == 0) {
					queue.add(new Point(nr, nc));
					flag = true;
				}

			}
		}
		
		return flag;
	}
	
}
