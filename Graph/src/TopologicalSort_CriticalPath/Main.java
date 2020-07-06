package TopologicalSort_CriticalPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Path {
	int num, time;

	Path(int n, int t) {
		num = n;
		time = t;
	}
}

class RePath {
	int v1, v2, cost;

	RePath(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		int prev[] = new int[n + 1];
		int cost[] = new int[n + 1];

		ArrayList<ArrayList<Path>> list = new ArrayList<>();
		ArrayList<ArrayList<Path>> reverse = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Path>());
			reverse.add(new ArrayList<Path>());
		}

		for (int i = 0; i < m; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int val = input.nextInt();

			list.get(v1).add(new Path(v2, val));
			reverse.get(v2).add(new Path(v1, val));
			prev[v2]++;
		}

		int start = input.nextInt();
		int finish = input.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (true) {
			if (queue.isEmpty())
				break;

			int temp = queue.poll();

			for (Path t : list.get(temp)) {
				prev[t.num]--;
				cost[t.num] = Math.max(cost[t.num], cost[temp] + t.time);
				if (prev[t.num] == 0) {
					queue.add(t.num);
				}
			}

		}

		Queue<RePath> reQueue = new LinkedList<>();
		boolean visit[][] = new boolean[n + 1][n + 1];

		int count = -1;

		reQueue.add(new RePath(finish, finish, 0));

		while (true) {
			if (reQueue.isEmpty())
				break;

			RePath temp = reQueue.poll();

			if (visit[temp.v1][temp.v2])
				continue;

			visit[temp.v1][temp.v2] = true;
			count++;

			for (Path t : reverse.get(temp.v2)) {
				if (cost[t.num] + t.time + temp.cost == cost[finish]) {
					reQueue.add(new RePath(temp.v2, t.num, temp.cost + t.time));
				}
			}

		}

		System.out.println(cost[finish]);
		System.out.println(count);
	}

}
