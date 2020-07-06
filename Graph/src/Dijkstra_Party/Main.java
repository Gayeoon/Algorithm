package Dijkstra_Party;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// Dijkstra
class Graph implements Comparable<Graph> {
	int v, e;

	Graph(int v, int e) {
		this.v = v;
		this.e = e;
	}

	@Override
	public int compareTo(Graph o) {
		return this.e >= o.e ? 1 : -1;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int x = input.nextInt();

		int[][] edge = new int[n][n];
		int[][] reverse = new int[n][n];

		for (int i = 0; i < m; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int val = input.nextInt();

			edge[v1 - 1][v2 - 1] = reverse[v2 - 1][v1 - 1] = val;
		}

		int[] result = dijkstra(edge, n, x - 1);
		int[] result2 = dijkstra(reverse, n, x - 1);
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(result[i] + result2[i], max);
		}
		System.out.println(max);
	}

	private static int[] dijkstra(int[][] edge, int n, int target) {
		// TODO Auto-generated method stub

		int[] dist = new int[n];
		boolean[] visit = new boolean[n];

		PriorityQueue<Graph> queue = new PriorityQueue<>();

		Arrays.fill(visit, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[target] = 0;

		queue.add(new Graph(target, 0));

		while (true) {
			if (queue.isEmpty())
				break;

			Graph temp = queue.poll();
			if (visit[temp.v])
				continue;

			visit[temp.v] = true;

			for (int i = 0; i < n; i++) {
				if (edge[temp.v][i] != 0 && !visit[i]) {
					if (dist[i] > edge[temp.v][i] + dist[temp.v]) {
						dist[i] = edge[temp.v][i] + dist[temp.v];
						queue.add(new Graph(i, dist[i]));

					}
				}
			}

		}

		return dist;
	}

}
