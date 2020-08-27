package B_11559;

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
	static char[][] arr = new char[12][6];
	static boolean visit[][];
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 12; i++) {
			arr[i] = input.next().toCharArray();
		}

		boolean flag = true;
		int cnt = 0;
		while (flag) {
			flag = false;
			visit = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] == '.' || visit[i][j])
						continue;

					if (bfs(i, j, arr[i][j])) {
						flag = true;
					}
				}
			}

			if (flag) {
				cnt++;
				down();
			}
			
		}
		
		System.out.println(cnt);
	}

	static boolean bfs(int row, int col, char color) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(row, col));
		visit[row][col] = true;
		
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(row, col));
		
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6)
					continue;

				if (visit[nr][nc] || arr[nr][nc] != color)
					continue;
				
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));			
				list.add(new Point(nr, nc));
			}
		}
		
		if(list.size() >= 4) {
			for(int i =0; i<list.size(); i++) {
				arr[list.get(i).row][list.get(i).col] = '.';
			}
			return true;
		}
		else
			return false;
	}
	
	static void down() {
		for(int j=0; j<6; j++) {
			ArrayList<Character> list = new ArrayList<>();
			
			for(int i=11; i>=0; i--) {
				if(arr[i][j] == '.') continue;
				list.add(arr[i][j]);
				arr[i][j] = '.';
			}
			
			int idx = 11;
			
			for(int i=0; i<list.size(); i++) {
				arr[idx][j] = list.get(i);
				idx--;
			}
		}
	}
}
