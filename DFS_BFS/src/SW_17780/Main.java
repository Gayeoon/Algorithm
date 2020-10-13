package SW_17780;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int row, col, dir, idx;

	Node(int row, int col, int dir, int idx) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.idx = idx;
	}
}

public class Main {
	static LinkedList<Node>[][] arr;
	static int color[][];
	static Node[] horse;
	static int n, m;
	static int Dr[] = { 0, 0, -1, 1 };
	static int Dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		arr = new LinkedList[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = new LinkedList<>();

		color = new int[n][n];

		horse = new Node[m + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				color[i][j] = input.nextInt();
		}

		for (int i = 1; i <= m; i++) {
			horse[i] = new Node(input.nextInt() - 1, input.nextInt() - 1, input.nextInt() - 1, i);
			arr[horse[i].row][horse[i].col].add(horse[i]);
		}

		System.out.println(solve());
	}

	static int solve() {
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j <= m; j++) {
				move(horse[j]);
				if (arr[horse[j].row][horse[j].col].size() >= 4) {
					return i;
				}
			}
		}
		return -1;
	}

	static void move(Node node) {
		if (arr[node.row][node.col].getFirst().idx != node.idx)
			return;

		int nr = node.row + Dr[node.dir];
		int nc = node.col + Dc[node.dir];

		if (nr < 0 || nr >= n || nc < 0 || nc >= n || color[nr][nc] == 2) {
			moveBlue(node);
			return;
		}
		if (color[nr][nc] == 0)
			moveWhite(node, nr, nc);
		else
			moveRed(node, nr, nc);
	}

	static void moveBlue(Node node) {
		int nDir = 0;
		switch (node.dir) {
		case 0:
			nDir = 1;
			break;
		case 1:
			nDir = 0;
			break;
		case 2:
			nDir = 3;
			break;
		case 3:
			nDir = 2;
			break;
		default:
			break;
		}
		
		Node tmp = arr[node.row][node.col].removeFirst();
		horse[tmp.idx] = new Node(node.row, node.col, nDir, tmp.idx);
		arr[node.row][node.col].addFirst(horse[tmp.idx]);

		int nr = node.row + Dr[nDir];
		int nc = node.col + Dc[nDir];
		
		if (nr < 0 || nr >= n || nc < 0 || nc >= n || color[nr][nc] == 2)
			return;

		if (color[nr][nc] == 0)
			moveWhite(horse[tmp.idx], nr, nc);
		else
			moveRed(horse[tmp.idx], nr, nc);
	}

	static void moveWhite(Node node, int nr, int nc) {
		while (arr[node.row][node.col].size() > 0) {
			Node tmp = arr[node.row][node.col].removeFirst();
			horse[tmp.idx] = new Node(nr, nc, tmp.dir, tmp.idx);
			arr[nr][nc].addLast(horse[tmp.idx]);
		}
	}

	static void moveRed(Node node, int nr, int nc) {
		while (arr[node.row][node.col].size() > 0) {
			Node tmp = arr[node.row][node.col].removeLast();
			horse[tmp.idx] = new Node(nr, nc, tmp.dir, tmp.idx);
			arr[nr][nc].addLast(horse[tmp.idx]);
		}
	}
}
