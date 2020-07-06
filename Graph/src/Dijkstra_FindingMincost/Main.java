package Dijkstra_FindingMincost;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class City implements Comparable<City> {
	int v, value;

	City(int v, int value) {
		this.v = v;
		this.value = value;
	}

	@Override
	public int compareTo(City o) {
		return this.value >= o.value ? 1 : -1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[] dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		int[][] edge = new int[N + 1][N + 1];

		Arrays.fill(visit, false);
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<City> queue = new PriorityQueue<>();

		for(int i=0; i<N+1; i++) {
			Arrays.fill(edge[i], -1);
		}
			
		for (int i = 0; i < M; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int value = input.nextInt();

			if(edge[v1][v2] != -1) edge[v1][v2] = Math.min(edge[v1][v2], value);
			else edge[v1][v2] = value;
		}

		int start = input.nextInt();
		int end = input.nextInt();

		dist[start] = 0;
		queue.add(new City(start, 0));
		while (true) {
			if (queue.isEmpty())
				break;
			City temp = queue.poll();
			if (visit[temp.v])
				continue;
			visit[temp.v] = true;

			for (int i = 1; i < N+1; i++) {
				if (edge[temp.v][i] != -1 && !visit[i]) {
					dist[i] = Math.min(dist[i], dist[temp.v] + edge[temp.v][i]);
					queue.add(new City(i, dist[i]));
				}
			}
		}
		
		System.out.println(dist[end]);
	}

}
