package SW_17780;

import java.io.*;
import java.util.*;

public class NewGame {
	private static class Node {
		int idx, x, y, dir;

		Node(int idx, int x, int y, int dir) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static int[][] info;
	static LinkedList<Node>[][] map;
	static int size, num;
	static final int WHITE = 0, RED = 1, BLUE = 2;
	static Node[] unit;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = stoi(st.nextToken());
		num = stoi(st.nextToken());

		init();

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				info[i][j] = stoi(st.nextToken());
			}
		}

		for (int i = 1; i <= num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken()) - 1;
			int y = stoi(st.nextToken()) - 1;
			int d = stoi(st.nextToken());

			unit[i] = new Node(i, x, y, d);
			map[x][y].add(unit[i]);
		}

		int time = 0;
		while (++time < 1000) {
			for (int i = 1; i <= num; i++) {
				move(unit[i]);
				if (isEnd(unit[i])) {
					System.out.println(time);
					return;
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isEnd(Node n) {
		return map[n.x][n.y].size() >= 4;
	}

	private static void move(Node n) {
		if (n.idx != map[n.x][n.y].getFirst().idx) {
			return;
		}

		int nx = n.x + dx[n.dir];
		int ny = n.y + dy[n.dir];

		if (nx >= 0 && ny >= 0 && nx < size && ny < size) {

			switch (info[nx][ny]) {
			case WHITE:
				moveWhite(n, nx, ny);
				break;
			case RED:
				moveRed(n, nx, ny);
				break;
			case BLUE:
				moveBlue(n, n.x + dx[reverseDir(n.dir)], n.y + dy[reverseDir(n.dir)]);
				break;
			}
		} else {
			moveBlue(n, n.x + dx[reverseDir(n.dir)], n.y + dy[reverseDir(n.dir)]);
		}

	}

	private static void moveWhite(Node n, int nx, int ny) {
		while (!map[n.x][n.y].isEmpty()) {
			Node temp = map[n.x][n.y].pollFirst();
			unit[temp.idx] = new Node(temp.idx, nx, ny, temp.dir);
			map[nx][ny].addLast(unit[temp.idx]);
		}
	}

	private static void moveRed(Node n, int nx, int ny) {
		while (!map[n.x][n.y].isEmpty()) {
			Node temp = map[n.x][n.y].pollLast();
			unit[temp.idx] = new Node(temp.idx, nx, ny, temp.dir);
			map[nx][ny].addLast(unit[temp.idx]);
		}
	}

	private static void moveBlue(Node n, int nx, int ny) {
		Node temp = map[n.x][n.y].pollFirst();
		map[n.x][n.y].addFirst(new Node(temp.idx, temp.x, temp.y, reverseDir(temp.dir)));

		if (nx >= 0 && ny >= 0 && nx < size && ny < size && info[nx][ny] != BLUE) {
			if (info[nx][ny] == RED) {
				moveRed(n, nx, ny);
			} else {
				moveWhite(n, nx, ny);
			}
		}
	}

	private static int reverseDir(int dir) {
		switch (dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return -1;
	}

	private static void init() {
		info = new int[size][size];
		unit = new Node[num + 1];
		map = new LinkedList[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}
