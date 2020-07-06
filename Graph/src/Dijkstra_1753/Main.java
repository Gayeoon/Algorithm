package Dijkstra_1753;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int v, val;

	Point(int v, int val) {
		this.v = v;
		this.val = val;
	}

	@Override
	public int compareTo(Point p) {
		if (this.val <= p.val)
			return -1;
		else
			return 1;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int v = input.nextInt();
		int e = input.nextInt();
		int start = input.nextInt();

		ArrayList<ArrayList<Point>> list = new ArrayList<>();

		for (int i = 0; i <= v; i++) {
			list.add(new ArrayList<Point>());
		}

		boolean[] visit = new boolean[v + 1];
		int[] dist = new int[v + 1];

		for (int i = 0; i < e; i++) {
			list.get(input.nextInt()).add(new Point(input.nextInt(), input.nextInt()));
		}

		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(start, 0));
		dist[start] = 0;

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			if (visit[tmp.v])
				continue;

			visit[tmp.v] = true;

			for (Point i : list.get(tmp.v)) {
				if (dist[i.v] > dist[tmp.v] + i.val) {
					dist[i.v] = dist[tmp.v] + i.val;
					queue.add(new Point(i.v, dist[i.v]));
				}

			}
		}

		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
}
