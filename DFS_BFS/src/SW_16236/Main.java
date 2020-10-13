package SW_16236;

import java.util.PriorityQueue;
import java.util.Scanner;

class Fish implements Comparable<Fish> {
	int row, col, time, val, eat, cnt;

	Fish(int row, int col, int time, int val) {
		this.row = row;
		this.col = col;
		this.time = time;
		this.val = val;
	}

	Fish(int row, int col, int val, int cnt, int time) {
		this.row = row;
		this.col = col;
		this.val = val;
		this.cnt = cnt;
		this.time = time;
	}

	@Override
	public int compareTo(Fish f) {
		if (this.time < f.time)
			return -1;
		else if (this.time == f.time) {
			if (this.row < f.time)
				return -1;
			else if (this.row == f.row) {
				if (this.col < f.col)
					return -1;
			}
		}
		return 1;
	}
}

public class Main {
	static int arr[][];
	static int n;
	static int result = 0;
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		n = input.nextInt();
		arr = new int[n][n];
		Fish shark = null;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] == 9) {
					shark = new Fish(i, j, 2, 0, 0);
					arr[i][j] = 0;
				}
			}
		}

		solve(shark);
		System.out.println(result);
	}

	static void solve(Fish shark) {
		Fish eat = eatFish(shark);

		if (eat == null)
			return;

		result += eat.time;
		arr[eat.row][eat.col] = 0;
		
		if (shark.val == shark.cnt + 1)
			shark = new Fish(eat.row, eat.col, shark.val + 1, 0, 0);
		else
			shark = new Fish(eat.row, eat.col, shark.val, shark.cnt + 1, 0);
		solve(shark);
	}

	static Fish eatFish(Fish shark) {
		PriorityQueue<Fish> queue = new PriorityQueue<>();
		queue.add(new Fish(shark.row, shark.col, 0, 0));
		boolean visit[][] = new boolean[n][n];
		visit[shark.row][shark.col] = true;
		Fish result = null;
		int time = Integer.MAX_VALUE;
		while (true) {
			if (queue.isEmpty())
				break;

			Fish tmp = queue.poll();

			if (tmp.val != 0 & tmp.val < shark.val) {
				if(tmp.time < time) {
					result = tmp;
					time = tmp.time;
				}
				else if(tmp.time == time) {
					if(result.row > tmp.row)
						result = tmp;
					else if(result.row == tmp.row)
						if(result.col > tmp.col)
							result = tmp;
				}
				continue;
			}
			
			if(tmp.time >= time)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc])
					continue;
				if (arr[nr][nc] > shark.val)
					continue;
				visit[nr][nc] = true;
				queue.add(new Fish(nr, nc, tmp.time + 1, arr[nr][nc]));
			}
		}

		return result;
	}
}
