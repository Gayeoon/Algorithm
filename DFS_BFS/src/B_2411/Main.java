package B_2411;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int row, col, item;

	Point(int row, int col, int item) {
		this.row = row;
		this.col = col;
		this.item = item;
	}

	void setItem(int item) {
		this.item = item;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		int[][] arr = new int[n][m];

		int item = input.nextInt();
		int obs = input.nextInt();

		int Dr[] = { 0, -1 };
		int Dc[] = { 1, 0 };

		for (int i = 0; i < item; i++) {
			arr[n-input.nextInt()][input.nextInt()-1] = 1;
		}

		for (int i = 0; i < obs; i++) {
			arr[n-input.nextInt()][input.nextInt()-1] = 2;
		}

		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(n-1, 0, 0));

		int cnt = 0;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (arr[tmp.row][tmp.col] == 1)
				tmp.setItem(tmp.item + 1);

			if (tmp.row == 0 && tmp.col == m - 1) {
				if (tmp.item == item)
					cnt++;
				continue;
			}
			
			for(int i=0; i<2; i++) {
				int nr = tmp.row+Dr[i];
				int nc = tmp.col+Dc[i];
				
				if(nr < 0 || nc >= m) continue;
				
				if(arr[nr][nc] == 2) continue;
				
				queue.add(new Point(nr, nc, tmp.item));
			}
		}
		
		System.out.println(cnt);

	}

}
