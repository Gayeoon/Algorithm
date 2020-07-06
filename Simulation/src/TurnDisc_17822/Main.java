package TurnDisc_17822;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Point {
	int row, col, val;

	Point(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

public class Main {
	static HashMap<Integer, LinkedList<Integer>> disc;
	static int Dr[] = { 1, 0 };
	static int Dc[] = { 0, 1 };
	static double avg = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int T = input.nextInt();

		disc = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = 0; j < M; j++) {
				list.add(input.nextInt());
			}
			disc.put(i, list);
		}

		for (int t = 0; t < T; t++) {
			int x = input.nextInt();
			int d = input.nextInt();
			int k = input.nextInt();

			turn(x, N, d, M, k);

			System.out.println("\n" + " -----------TURN-----------");
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(disc.get(i).get(j) + " ");
					// sum += disc.get(i).get(j);
				}
				System.out.println();
			}
			System.out.println();
			find(N, M);
			System.out.println("\n" + " -----------FIND-----------");
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(disc.get(i).get(j) + " ");
//					sum += disc.get(i).get(j);
				}
				System.out.println();
			}
			System.out.println();
		}

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				sum += disc.get(i).get(j);
			}
		}
		System.out.println(sum);
	}

	static void turn(int x, int n, int d, int m, int K) {
		K %= m;
		if (K > m / 2) {
			d &= ~(1 << 0);
			K = m - K;
		}
		for (int i = x; i <= n; i += x) {
			int k = K;
			while (k > 0) {
				if (d == 0) {
					LinkedList<Integer> list = disc.get(i);
					int tmp = list.getLast();
					list.removeLast();
					list.add(0, tmp);
					disc.put(i, list);
				} else {
					LinkedList<Integer> list = disc.get(i);
					int tmp = list.getFirst();
					list.removeFirst();
					list.addLast(tmp);
					disc.put(i, list);
				}
				k--;
			}
		}
	}

	static void find(int N, int M) {
		int[][] temp = new int[N + 1][M];
		int sum = 0;
		int cnt = 0;
		boolean flag = true;
		for (int i = 1; i <= N; i++) {
			LinkedList<Integer> list = disc.get(i);
			for (int j = 0; j < M; j++) {
				if (list.get(j) == 0)
					continue;

				for (int k = 0; k < 2; k++) {
					int nr = i + Dr[k];
					int nc = j + Dc[k];
					if (nr > N)
						continue;
					if (nc >= M)
						nc = 0;

					if (list.get(j) == disc.get(nr).get(nc)) {
						temp[i][j] = temp[nr][nc] = -1;
						flag = false;
					}
				}
				if (flag) {
					sum += list.get(j);
					cnt++;
				}
			}
		}
		if (flag && cnt != 0) {
			avg = (double) sum / cnt;
		}

		for (int i = 1; i <= N; i++) {
			LinkedList<Integer> list = disc.get(i);
			LinkedList<Integer> newList = new LinkedList<>();
			if (avg == 0) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == -1)
						newList.add(0);
					else
						newList.add(list.get(j));
				}
			} else {
				for (int j = 0; j < M; j++) {
					if (list.get(j) == 0)
						newList.add(0);
					else if (list.get(j) > avg)
						newList.add(list.get(j) - 1);
					else if (list.get(j) < avg)
						newList.add(list.get(j) + 1);
					else
						newList.add(list.get(j));
				}
			}
			disc.put(i, newList);
		}
		avg = 0;
	}
}
