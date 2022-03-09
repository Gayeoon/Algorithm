package B_1245;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int row, col, val;

	Node(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public int compareTo(Node n) {
		if (this.val >= n.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] visit;
	static int[] Dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] Dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		arr = new int[N][M];
		visit = new boolean[N][M];

		PriorityQueue<Node> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.nextInt();
				queue.add(new Node(i, j, arr[i][j]));
			}
		}

		int answer = 0;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			if (visit[tmp.row][tmp.col] || tmp.val == 0)
				continue;

			check(tmp);
			answer++;
		}

		System.out.println(answer);
	}

	static void check(Node node) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(node);
		visit[node.row][node.col] = true;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || arr[nr][nc] > tmp.val)
					continue;

				visit[nr][nc] = true;
				queue.add(new Node(nr, nc, arr[nr][nc]));
			}
		}
	}
}
