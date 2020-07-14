package B_5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int v, val;

	Point(int v, int val) {
		this.v = v;
		this.val = val;
	}

	@Override
	public int compareTo(Point p) {
		if (this.val < p.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int[][] arr;
	static ArrayList<ArrayList<Integer>> trace;
	static int[] dist;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;
			arr = new int[n][n];
			trace = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				trace.add(new ArrayList<Integer>());
			}

			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				arr[x][y] = val;
			}

			dist = new int[n];
			visit = new boolean[n];
			solve(start, end);
			traceBack(start, end);

			dist = new int[n];
			visit = new boolean[n];
			int result = solve(start, end);
			if (result == Integer.MAX_VALUE)
				sb.append("-1\n");
			else
				sb.append(result + "\n");
		}
		System.out.print(sb);
	}

	static int solve(int start, int end) {
		PriorityQueue<Point> queue = new PriorityQueue<>();

		queue.add(new Point(start, 0));
		visit[start] = true;
		dist[start] = 0;

		int min = Integer.MAX_VALUE;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();
			if (tmp.v == end) {
				min = Math.min(min, tmp.val);
				continue;
			}

			if (tmp.val >= min)
				continue;

			for (int i = 0; i < arr[0].length; i++) {
				if (arr[tmp.v][i] != 0) {
					if (dist[i] >= dist[tmp.v] + arr[tmp.v][i] || !visit[i]) {
						dist[i] = dist[tmp.v] + arr[tmp.v][i];
						visit[i] = true;
						queue.add(new Point(i, dist[i]));
						trace.get(i).add(tmp.v);
					}
				}
			}
		}
		return min;
	}

	static void traceBack(int start, int end) {
		PriorityQueue<Point> queue = new PriorityQueue<>();

		queue.add(new Point(end, 0));

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			for (int i : trace.get(tmp.v)) {
				if (dist[tmp.v] == dist[i] + arr[i][tmp.v]) {
					arr[i][tmp.v] = 0;
					queue.add(new Point(i, dist[i]));
				}
			}
		}
	}
}
