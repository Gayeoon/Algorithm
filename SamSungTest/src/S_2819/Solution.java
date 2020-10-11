package S_2819;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;

class Point {
	int row, col;
	String str;

	Point(int row, int col, String str) {
		this.row = row;
		this.col = col;
		this.str = str;
	}
}

public class Solution {
	static int arr[][];
	static HashSet<String> set;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			arr = new int[4][4];
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					solve(i, j);
				}
			}
			sb.append("#" + test_case + " " + set.size() + "\n");
		}
		System.out.print(sb);
	}

	static void solve(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col, arr[row][col] + ""));

		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();
			if (tmp.str.length() == 7) {
				set.add(tmp.str);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4)
					continue;
				queue.add(new Point(nr, nc, tmp.str + arr[nr][nc]));
			}
		}
	}
}