package S_1227;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			char arr[][] = new char[100][100];
			Point start = null, end = null;

			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				if (str.contains("2") || str.contains("3")) {
					for (int j = 0; j < 100; j++) {
						arr[i][j] = str.charAt(j);
						if (arr[i][j] == '2') {
							start = new Point(i, j);
						} else if (arr[i][j] == '3')
							end = new Point(i, j);
					}
				} else
					arr[i] = str.toCharArray();
			}

			Queue<Point> queue = new LinkedList<>();
			boolean visit[][] = new boolean[100][100];
			visit[start.row][start.col] = true;
			queue.add(start);
			boolean flag = false;
			while (true) {
				if (queue.isEmpty())
					break;
				Point tmp = queue.poll();

				if (tmp.row == end.row & tmp.col == end.col) {
					flag = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = tmp.row + Dr[i];
					int nc = tmp.col + Dc[i];

					if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100)
						continue;
					if (visit[nr][nc] || arr[nr][nc] == '1')
						continue;
					visit[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
			if (flag)
				sb.append("#" + n + " 1" + "\n");
			else
				sb.append("#" + n + " 0" + "\n");

		}
		System.out.print(sb);
	}
}