package B_2933;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(Point p) {
		if (this.row > p.row)
			return -1;
		else if(this.row == p.row)
			return 0;
		else
			return 1;

	}
}

public class Main {
	static char[][] arr;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static int n, m;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = input.next();
			arr[i] = str.toCharArray();
		}

		int k = input.nextInt();

		boolean f = true;
		for (int i = 0; i < k; i++) {
			int bar = n - input.nextInt();
			shoot(bar, f);
			f = !f;
			
//			System.out.println("\n------------"+bar+"------------\n");
//			for (int a = 0; a < n; a++) {
//				for (int b = 0; b < m; b++)
//					System.out.print(arr[a][b]);
//				System.out.println();
//			}
		}
		
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++)
				System.out.print(arr[a][b]);
			System.out.println();
		}

	}

	static void shoot(int bar, boolean flag) {
		if (flag) {
			for (int i = 0; i < m; i++) {
				if (arr[bar][i] == 'x') {
					arr[bar][i] = '.';
					for (int k = 0; k < 4; k++) {
						int nr = bar + Dr[k];
						int nc = i + Dc[k];

						if (nr < 0 || nc < 0 || nr >= n || nc >= m)
							continue;
						if (arr[nr][nc] == '.')
							continue;
						bsf(nr, nc);
					}
					break;
				}
			}
		} else {
			for (int i = m - 1; i >= 0; i--) {
				if (arr[bar][i] == 'x') {
					arr[bar][i] = '.';
					
					for (int k = 0; k < 4; k++) {
						int nr = bar + Dr[k];
						int nc = i + Dc[k];

						if (nr < 0 || nc < 0 || nr >= n || nc >= m)
							continue;
						if (arr[nr][nc] == '.')
							continue;
						bsf(nr, nc);
					}
										
					break;
				}
			}
		}
	}

	static void bsf(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		boolean visit[][] = new boolean[n][m];
		visit[row][col] = true;
		LinkedList<Point> list = new LinkedList<>();
		list.add(new Point(row, col));
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (visit[nr][nc] || arr[nr][nc] == '.')
					continue;

				queue.add(new Point(nr, nc));
				list.add(new Point(nr, nc));
				visit[nr][nc] = true;

			}
		}
		
		boolean flag = true;
		while (flag) {
			list.sort(null);

			char temp[][] = new char[n][m];
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					temp[i][j] = arr[i][j];
			
			LinkedList<Point> newlist = new LinkedList<>();
			int cnt = 0;
			for (Point p : list) {
				if (p.row == n - 1 || arr[p.row+1][p.col] == 'x') {
					flag = false;
					if(cnt != 0) {
						for(int i=0; i<n; i++)
							for(int j=0; j<m; j++)
								arr[i][j] = temp[i][j];
					}
					break;
				}
				arr[p.row + 1][p.col] = arr[p.row][p.col];
				arr[p.row][p.col] = '.';
				newlist.add(new Point(p.row+1, p.col));
				cnt++;
			}
			
			list = newlist;
		}
	}
}
