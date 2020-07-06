package ComplexNumber_2667;

import java.util.ArrayList;
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

	static int[][] arr;
	static int Dr[] = { 1, 0, -1, 0 };
	static int Dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		arr = new int[n][n];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					list.add(solve(i, j));
				}
			}
		}
		list.sort(null);
		
		System.out.println(list.size());
		for(int tmp : list)
			System.out.println(tmp);

	}

	static int solve(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		arr[row][col] = 0;
		int cnt = 1;
		while (true) {
			if (queue.isEmpty())
				break;
			Point temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp.row + Dr[i];
				int nc = temp.col + Dc[i];

				if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
					continue;
				if (arr[nr][nc] == 1) {
					cnt++;
					arr[nr][nc] = 0;
					queue.add(new Point(nr, nc));
				}
			}
		}
		return cnt;
	}
}
