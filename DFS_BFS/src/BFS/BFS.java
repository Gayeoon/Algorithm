package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	static String vertex[];
	static int d[];
	static boolean a[][] = new boolean[8][8];

	public static void bfs(String r) {
		int root = index(r);
		d = new int[vertex.length];

		for (int i = 0; i < vertex.length; i++) {
			d[i] = (int) Double.POSITIVE_INFINITY;
		}

		d[root] = 0;

		Queue<String> queue = new LinkedList<String>();

		queue.add(r);

		while (!queue.isEmpty()) {

			String temp = queue.remove();

			for (int j = 0; j < 8; j++) {
				if (a[index(temp)][j] & d[j] == (int) Double.POSITIVE_INFINITY) {
					queue.add(vertex[j]);
					d[j] = d[index(temp)] + 1;
				}
			}
		}

		System.out.println("그래프의 부모 정점 : " + r);

	}

	public static int index(String v) {
		for (int i = 0; i < vertex.length; i++) {
			if (vertex[i] == v) {
				return i;
			}
		}
		return -1;
	}

	public static void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		vertex = new String[] { "r", "s", "t", "u", "v", "w", "x", "y" };

		add("r", "s");
		add("r", "v");
		add("s", "w");
		add("t", "w");
		add("t", "x");
		add("w", "x");
		add("x", "u");
		add("x", "y");
		add("y", "u");
		add("t", "u");

		bfs("s");

		for (int i = 0; i < d.length; i++) {
			System.out.println(vertex[i] + " : " + d[i]);
		}
	}

}


