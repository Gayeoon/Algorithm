package SW_19238;

import java.util.PriorityQueue;
import java.util.Scanner;

class Taxi implements Comparable<Taxi> {
	int row, col, time, idx;
	int dRow, dCol;
	boolean flag;

	Taxi(int row, int col, int time, int idx) {
		this.row = row;
		this.col = col;
		this.time = time;
		this.idx = idx;
	}

	Taxi(int row, int col, int dRow, int dCol, boolean flag) {
		this.row = row;
		this.col = col;
		this.dRow = dRow;
		this.dCol = dCol;
		this.flag = flag;
	}

	@Override
	public int compareTo(Taxi t) {
		if (this.time < t.time) {
			return -1;
		} else if (this.time == t.time)
			if (this.row < t.row)
				return -1;
		return 1;
	}
}

public class Main {
	static int arr[][];
	static int Dr[] = { -1, 0, 1, 0 };
	static int Dc[] = { 0, -1, 0, 1 };
	static int n, m;
	static Taxi[] guest;
	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		int oil = input.nextInt();

		guest = new Taxi[m + 1];

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] == 1)
					arr[i][j] = -1;
			}
		}

		Taxi taxi = new Taxi(input.nextInt() - 1, input.nextInt() - 1, oil, 0);

		for (int i = 1; i <= m; i++) {
			guest[i] = new Taxi(input.nextInt() - 1, input.nextInt() - 1, input.nextInt() - 1, input.nextInt() - 1,
					true);
		}
		
		for (int i = 1; i <= m; i++) {
			arr[guest[i].row][guest[i].col] = i;
		}

		solve(taxi, 0);
		System.out.println(result);
	}

	static void solve(Taxi taxi, int cnt) {

		if (cnt == m) {
			result = taxi.time;
			return;
		}
		
		Taxi person = moveTaxi(taxi);

		if (person == null) {
			result = -1;
			return;
		}

		int oil = person.time;
		if (taxi.time - oil <= 0) {
			result = -1;
			return;
		}

		arr[guest[person.idx].row][guest[person.idx].col] = 0;
		

		int oil2 = movePerson(guest[person.idx]);

		if (oil2 == Integer.MAX_VALUE || taxi.time - oil - oil2 < 0) {
			result = -1;
			return;
		}

		taxi = new Taxi(guest[person.idx].dRow, guest[person.idx].dCol, taxi.time - oil - oil2 + (oil2 * 2), 0);
		solve(taxi, cnt + 1);

	}

	static int movePerson(Taxi person) {
		PriorityQueue<Taxi> queue = new PriorityQueue<>();
		boolean visit[][] = new boolean[n][n];

		queue.add(new Taxi(person.row, person.col, 0, 0));
		visit[person.row][person.col] = true;
		int time = Integer.MAX_VALUE;
		while (true) {
			if (queue.isEmpty())
				break;

			Taxi tmp = queue.poll();

			if (tmp.row == person.dRow & tmp.col == person.dCol) {
				time = tmp.time;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (arr[nr][nc] == -1 || visit[nr][nc])
					continue;

				visit[nr][nc] = true;
				queue.add(new Taxi(nr, nc, tmp.time + 1, 0));
			}
		}

		return time;
	}

	static Taxi moveTaxi(Taxi taxi) {
		if(arr[taxi.row][taxi.col] > 0) {
			return new Taxi(taxi.row, taxi.col, 0, arr[taxi.row][taxi.col]);
		}
		
		PriorityQueue<Taxi> queue = new PriorityQueue<>();
		boolean visit[][] = new boolean[n][n];

		queue.add(new Taxi(taxi.row, taxi.col, 0, 0));
		visit[taxi.row][taxi.col] = true;

		Taxi result = null;
		int time = Integer.MAX_VALUE;
		while (true) {
			if (queue.isEmpty())
				break;

			Taxi tmp = queue.poll();

			if (arr[tmp.row][tmp.col] != 0) {
				if (tmp.time < time) {
					result = tmp;
					time = tmp.time;
				} else if (tmp.time == time) {
					if (tmp.row < result.row)
						result = tmp;
					else if (tmp.row == result.row)
						if (tmp.col < result.col)
							result = tmp;
				}
				continue;
			}

			if (tmp.time >= time)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (arr[nr][nc] == -1 || visit[nr][nc])
					continue;

				visit[nr][nc] = true;
				queue.add(new Taxi(nr, nc, tmp.time + 1, arr[nr][nc]));
			}
		}

		return result;
	}
}
