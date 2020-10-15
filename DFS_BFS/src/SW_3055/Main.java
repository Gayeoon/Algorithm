package SW_3055;

import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
	int row, col, time;
	char move;

	Pair(int row, int col, int time, char move) {
		this.row = row;
		this.col = col;
		this.time = time;
		this.move = move;
	}

	@Override
	public int compareTo(Pair p) {
		if (this.time < p.time)
			return -1;
		return 1;
	}
}

public class Main {
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		char[][] arr = new char[n][m];
		PriorityQueue<Pair> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '*' || arr[i][j] == 'S')
					queue.add(new Pair(i, j, 0, arr[i][j]));
			}
		}

		int result = Integer.MAX_VALUE;
		
		loop: while (true) {
			if (queue.isEmpty())
				break;

			Pair tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (arr[nr][nc] == '*' || arr[nr][nc] == 'X')
					continue;

				if (tmp.move == '*') {
					if (arr[nr][nc] == 'D')
						continue;
					arr[nr][nc] = '*';
					queue.add(new Pair(nr, nc, tmp.time + 1, '*'));
				} else {
					if (arr[nr][nc] == 'D') {
						result = tmp.time+1;
						break loop;
					} else if (arr[nr][nc] == '.') {
						arr[nr][nc] = 'S';
						queue.add(new Pair(nr, nc, tmp.time + 1, 'S'));
					}
				}
			}
		}

		if (result == Integer.MAX_VALUE)
			System.out.println("KAKTUS");
		else
			System.out.println(result);
	}

}
