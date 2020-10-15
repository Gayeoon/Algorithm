package SW_17837;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int row, col, dir, idx, num;

	Node(int row, int col, int dir, int idx, int num) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.idx = idx;
		this.num = num;
	}

	Node(int dir, int idx) {
		this.dir = dir;
		this.idx = idx;
	}
}

public class Main {
	static int color[][];
	static LinkedList<Node> map[][];
	static Node horse[];
	static int n, k;
	static int Dr[] = { 1, 0, 0, -1 };
	static int Dc[] = { 0, 1, -1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();

		color = new int[n][n];
		map = new LinkedList[n][n];
		horse = new Node[k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				color[i][j] = input.nextInt();
				map[i][j] = new LinkedList<Node>();
			}
		}

		for (int i = 0; i < k; i++) {
			int row = input.nextInt() - 1;
			int col = input.nextInt() - 1;
			int dir = (input.nextInt() % 4);
			horse[i] = new Node(row, col, dir, i, 0);
			map[row][col].add(new Node(dir, i));
		}
		System.out.println(solve());
	}

	static int solve() {
		for (int turn = 1; turn <= 1000; turn++) {
			for (int i = 0; i < k; i++) {
				move(horse[i]);

				if (map[horse[i].row][horse[i].col].size() >= 4)
					return turn;
			}
		}
		return -1;
	}

	static void move(Node node) {
		int nr = node.row + Dr[node.dir];
		int nc = node.col + Dc[node.dir];

		if (nr < 0 || nr >= n || nc < 0 || nc >= n || color[nr][nc] == 2) {
			moveBlue(node);
		} else if (color[nr][nc] == 1) {
			moveRed(node, nr, nc);
		} else if (color[nr][nc] == 0) {
			moveWhite(node, nr, nc);
		}

	}

	static void moveWhite(Node node, int nr, int nc) {
		int idx = map[nr][nc].size();

		while (true) {
			if (map[node.row][node.col].size() <= node.num)
				break;
			Node tmp = map[node.row][node.col].remove(node.num);
			horse[tmp.idx] = new Node(nr, nc, tmp.dir, tmp.idx, idx++);
			map[nr][nc].addLast(horse[tmp.idx]);
		}
	}

	static void moveRed(Node node, int nr, int nc) {
		int idx = map[nr][nc].size();

		while (true) {
			if (map[node.row][node.col].getLast().idx == node.idx) {
				Node tmp = map[node.row][node.col].removeLast();
				horse[tmp.idx] = new Node(nr, nc, tmp.dir, tmp.idx, idx++);
				map[nr][nc].addLast(horse[tmp.idx]);
				break;
			}
			Node tmp = map[node.row][node.col].removeLast();
			horse[tmp.idx] = new Node(nr, nc, tmp.dir, tmp.idx, idx++);
			map[nr][nc].addLast(horse[tmp.idx]);
		}
	}

	static void moveBlue(Node node) {
		int dir = 0;
		switch (node.dir) {
		case 0:
			dir = 3;
			break;
		case 1:
			dir = 2;
			break;
		case 2:
			dir = 1;
			break;
		case 3:
			dir = 0;
			break;
		}

		int nr = node.row + Dr[dir];
		int nc = node.col + Dc[dir];
		horse[node.idx].dir = dir;
		map[node.row][node.col].get(node.num).dir = dir;
		if (nr < 0 || nr >= n || nc < 0 || nc >= n || color[nr][nc] == 2) {
			return;
		} else if (color[nr][nc] == 1) {
			moveRed(horse[node.idx], nr, nc);
		} else if (color[nr][nc] == 0) {
			moveWhite(horse[node.idx], nr, nc);
		}
	}
}
