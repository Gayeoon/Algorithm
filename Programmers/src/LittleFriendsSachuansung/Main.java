package LittleFriendsSachuansung;

import java.util.Arrays;
import java.util.PriorityQueue;


class Dot implements Comparable<Dot> {
	int row, col;
	String s;

	Dot(int row, int col, String s) {
		this.row = row;
		this.col = col;
		this.s = s;
	}

	@Override
	public int compareTo(Dot d) {
		return this.s.compareTo(d.s);
	}
}

class Dot2 implements Comparable<Dot2> {
	int row, col, val;
	String s;

	Dot2(int row, int col, String s, int val) {
		this.row = row;
		this.col = col;
		this.s = s;
		this.val = val;
	}

	@Override
	public int compareTo(Dot2 d) {
		if(this.val >= d.val)
			return -1;
		else return 1;
	}
}

public class Main {
	static int M, N;
	static String[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int m = 3;
//		int n = 3;
//		String[] board = { "DBA", "C*A", "CDB" };

//		int m = 2;
//		int n = 4;
//		String[] board = { "NRYN", "ARYA" };

//		int m = 4;
//		int n = 4;
//		String[] board = { ".ZI.", "M.**", "MZU.", ".IU." };

		int m = 5;
		int n = 5;
		String[] board = { "CDDDC", "DBCBD", "DCACD" , "DBCBD", "CDDDC"};

		String answer = "";
		arr = new String[m][n];
		visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = board[i].charAt(j) + "";
			}
		}
		M = m;
		N = n;
		PriorityQueue<Dot> queue = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j].equals(".") || arr[i][j].equals("*") || visit[i][j])
					continue;
				visit[i][j] = true;
				PriorityQueue<Dot2> value = new PriorityQueue<>();
				value = find(i, j, arr[i][j], -1,  false, value);
				if (value.size() != 0) {
					Dot2 temp = value.poll();
					System.out.println(temp.s + " : " + i + " " + j + " ----> " + temp.row + " " + temp.col);
					queue.add(new Dot(i, j, arr[i][j]));
					visit[temp.row][temp.col] = true;
				} else
					visit[i][j] = false;
			}
		}

		for (int i = 0; i < M; i++) {
			Arrays.fill(visit[i], false);
		}
		while (true) {
			if (queue.isEmpty())
				break;
			Dot dot = queue.poll();
			if (arr[dot.row][dot.col].equals("."))
				continue;
			visit[dot.row][dot.col] = true;
			PriorityQueue<Dot2> value = new PriorityQueue<>();
			value = find(dot.row, dot.col, dot.s, -1, false, value);
			if (value.size() != 0) {
				Dot2 temp = value.poll();
				answer += temp.s;
				System.out.println(temp.s + " : " + dot.row + " " + dot.col + " ----> " + temp.row + " " + temp.col);
				arr[temp.row][temp.col] = ".";
				arr[dot.row][dot.col] = ".";
				int Dr[] = { -1, 1, 0, 0 };
				int Dc[] = { 0, 0, -1, 1 };
				for (int i = 0; i < 4; i++) {
					int nr = Dr[i] + temp.row;
					int nc = Dc[i] + temp.col;

					if (nr < 0 || nr >= M || nc < 0 || nc >= N)
						continue;
					if (arr[nr][nc].equals("*") || arr[nr][nc].equals("."))
						continue;
					queue.add(new Dot(nr, nc, arr[nr][nc]));
				}
				for (int i = 0; i < 4; i++) {
					int nr = Dr[i] + dot.row;
					int nc = Dc[i] + dot.col;

					if (nr < 0 || nr >= M || nc < 0 || nc >= N)
						continue;
					if (arr[nr][nc].equals("*") || arr[nr][nc].equals("."))
						continue;
					queue.add(new Dot(nr, nc, arr[nr][nc]));
				}

			}
			visit[dot.row][dot.col] = false;
		}

		if (answer.equals(""))
			System.out.println("IMPOSSIBLE");
		System.out.println(answer);
		// return answer;
	}

	static int check(int row, int col, String target) {
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = Dr[i] + row;
			int nc = Dc[i] + col;

			if (nr < 0 || nr >= M || nc < 0 || nc >= N)
				continue;
			if (arr[nr][nc].equals("*") || arr[nr][nc].equals("."))
				continue;
			count++;
		}
		return count;
	}

	static PriorityQueue<Dot2> find(int row, int col, String target, int dir, boolean turn,
			PriorityQueue<Dot2> value) {
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };
		Dot temp = null;

		if (!turn) {
			for (int i = 0; i < 4; i++) {
				int nr = Dr[i] + row;
				int nc = Dc[i] + col;

				if (nr < 0 || nr >= M || nc < 0 || nc >= N || visit[nr][nc])
					continue;
				if (arr[nr][nc].equals("*"))
					continue;
				if (arr[nr][nc].equals(target)) {
					
					int max = check(nr, nc, target);
					value.add(new Dot2(nr, nc, target, max));
				}
				if (arr[nr][nc].equals(".")) {

					if (dir == -1) {
						visit[nr][nc] = true;

						PriorityQueue<Dot2> t = find(nr, nc, target, i, false, value);
						if (t != null && t.size() != 0) {
							int max = check(nr, nc, target);
							value.add(new Dot2(t.peek().row, t.peek().col, target, max));
						}
						visit[nr][nc] = false;
					} else {

						visit[nr][nc] = true;
						if (dir == i) {
							PriorityQueue<Dot2> t = find(nr, nc, target, i, false, value);
							if (t != null && t.size() != 0) {
								int max = check(nr, nc, target);
								value.add(new Dot2(t.peek().row, t.peek().col, target, max));
							}
						} else {
							PriorityQueue<Dot2> t = find(nr, nc, target, i, true, value);
							if (t != null && t.size() != 0) {
								int max = check(nr, nc, target);
								value.add(new Dot2(nr, nc, target, max));
							}
						}
						visit[nr][nc] = false;

					}
				}
			}
			return value;
		} else {
			int nr = Dr[dir] + row;
			int nc = Dc[dir] + col;
			while (true) {
				if (nr < 0 || nr >= M || nc < 0 || nc >= N || visit[nr][nc])
					return null;
				if (arr[nr][nc].equals("*"))
					return null;
				if (arr[nr][nc].equals(target)) {
					PriorityQueue<Dot2> tempQueue = new PriorityQueue<Dot2>();
					tempQueue.add(new Dot2(nr, nc, target, 0));
					return tempQueue;
				}if(!arr[nr][nc].equals(".")) return null;
				nr += Dr[dir];
				nc += Dc[dir];

			}
		}
	}
}
