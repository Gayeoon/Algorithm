package B_17136;

import java.util.LinkedList;
import java.util.Scanner;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int result = Integer.MAX_VALUE;
	static int paper[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int arr[][] = new int[10][10];
		LinkedList<Point> list = new LinkedList<>();

		paper = new int[6];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] == 1)
					list.add(new Point(i, j));
			}
		}
		solve(list, arr, 0, 0);
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);

	}

	static boolean solve(LinkedList<Point> list, int[][] arr, int idx, int cnt) {
		if (result <= cnt)
			return true;

		boolean flag = true;
		boolean stop = false;

		loop: while (flag) {
			if (idx >= list.size()) {
				result = Math.min(result, cnt);
				break;
			}
			Point tmp = list.get(idx);
			int i = tmp.row;
			int j = tmp.col;

			if (arr[i][j] == 0) {
				idx++;
				continue;
			}

			for (int k = 5; k > 0; k--) {
				if (paper[k] < 5 && attach(arr, i, j, k, 2)) {
					attach(arr, i, j, k, 0);
					paper[k]++;

					stop = solve(list, arr, idx + 1, cnt + 1);
					attach(arr, i, j, k, 1);
					paper[k]--;
					flag = false;
					if (stop)
						break loop;
				}
			}

			if (flag) {
				result = Math.min(result, Integer.MAX_VALUE);
				return false;
			}
		}
		return false;
	}

	static boolean attach(int[][] arr, int row, int col, int k, int flag) {
		if (flag == 2) {
			for (int n = 0; n < k; n++) {
				for (int m = 0; m < k; m++) {
					if (row + n >= 10 || col + m >= 10)
						return false;
					if (arr[row + n][col + m] == 0)
						return false;
				}
			}
			return true;
		} else {
			for (int n = row; n < row + k; n++) {
				for (int m = col; m < col + k; m++) {
					arr[n][m] = flag;
				}
			}
		}

		return true;
	}
}
