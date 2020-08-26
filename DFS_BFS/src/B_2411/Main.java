package B_2411;

import java.util.Scanner;
import java.util.LinkedList;

class Point implements Comparable<Point> {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public int compareTo(Point p) {
		if (this.row < p.row && this.col < p.col)
			return -1;
		else if (this.row == p.row && this.col < p.col)
			return -1;
		else if (this.row < p.row && this.col == p.col)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		arr = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		int item = input.nextInt();
		int obs = input.nextInt();
		LinkedList<Point> list = new LinkedList<>();

		for (int i = 0; i < item; i++) {
			int r = input.nextInt();
			int c = input.nextInt();

			arr[r][c] = 1;
			list.add(new Point(r, c));
		}

		for (int i = 0; i < obs; i++) {
			arr[input.nextInt()][input.nextInt()] = 2;
		}

		int row = 1, col = 1;
		list.sort(null);

		if(arr[1][1] != 2)
			dp[1][1] = 1;
		
		for (int i = 0; i < list.size(); i++) {
			move(row, col, list.get(i).row, list.get(i).col);
			row = list.get(i).row;
			col = list.get(i).col;

		}
		
		move(row, col, n, m);

		System.out.println(dp[n][m]);

	}

	static void move(int s_row, int s_col, int e_row, int e_col) {
		for (int i = s_row; i <= e_row; i++) {
			for (int j = s_col; j <= e_col; j++) {
				if (arr[i][j] == 2) {
					dp[i][j] = 0;
					continue;
				}
				if(i == 1 && j == 1) continue;
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
	}
}
