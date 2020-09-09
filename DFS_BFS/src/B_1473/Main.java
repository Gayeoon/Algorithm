package B_1473;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, time;
	char door;
	char room[][];

	Point(int row, int col, char door, int time, char[][] room) {
		this.row = row;
		this.col = col;
		this.door = door;
		this.time = time;
		this.room = room;
	}

	@Override
	public int compareTo(Point p) {
		if (this.time < p.time)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static HashMap<Character, int[]> hash = new HashMap<>();
	static int[] Dr = { -1, 0, 1, 0 };
	static int[] Dc = { 0, 1, 0, -1 };
	static int[] dir = { 2, 3, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int tmpInt[][] = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };

		hash.put('A', tmpInt[0]);
		hash.put('B', tmpInt[1]);
		hash.put('C', tmpInt[2]);
		hash.put('D', tmpInt[3]);

		int n = input.nextInt();
		int m = input.nextInt();

		char[][] arr = new char[n][m];

		for (int i = 0; i < n; i++)
			arr[i] = input.next().toCharArray();

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, arr[0][0], 0, arr));

		int min = Integer.MAX_VALUE;
		boolean check[][] = new boolean[n][m];
		boolean visit[][] = new boolean[n][m];
		visit[0][0] = true;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.row == n - 1 && tmp.col == m - 1) {
				min = Math.min(min, tmp.time);
				continue;
			}

			if (tmp.time >= min)
				continue;
			
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if(visit[nr][nc])
					continue;
				if(tmp.room[nr][nc] == 'C' || tmp.room[nr][nc] == 'D' )
					cnt++;
				if (hash.get(tmp.door)[i] == 1 || hash.get(tmp.room[nr][nc])[dir[i]] == 1)
					continue;
				queue.add(new Point(nr, nc, tmp.room[nr][nc], tmp.time + 1, tmp.room));
				visit[nr][nc] = true;
			}
			
			if (cnt > 0 && !check[tmp.row][tmp.col]) {
				check[tmp.row][tmp.col] = true;
				queue.add(new Point(tmp.row, tmp.col, tmp.door, tmp.time + 1, button(tmp.row, tmp.col, tmp.room)));
			}
		}
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static char[][] button(int row, int col, char[][] room) {
		char[][] tmp = new char[room.length][room[0].length];
		char temp = room[row][col];

		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				if (i == row || j == col) {
					switch (room[i][j]) {
					case 'C':
						tmp[i][j] = 'D';
						break;
					case 'D':
						tmp[i][j] = 'C';
						break;
					default:
						tmp[i][j] = room[i][j];
						break;
					}
				} else {
					tmp[i][j] = room[i][j];
				}
			}
		}

		tmp[row][col] = temp;
		return tmp;
	}

}
