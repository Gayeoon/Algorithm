package MinimumSpanningTree_1944;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int idx, row, col, val;

	Point(int idx, int row, int col, int val) {
		this.idx = idx;
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

class Dist implements Comparable<Dist> {
	int v1, v2, val;

	Dist(int v1, int v2, int val) {
		this.v1 = v1;
		this.v2 = v2;
		this.val = val;
	}

	@Override
	public int compareTo(Dist d) {
		if (this.val < d.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int maze[][];
	static PriorityQueue<Dist> dist;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, - 1, 1 };
	static int n, m;
	static int[] parent;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		maze = new int[n][n];
		LinkedList<Point> list = new LinkedList<>();
		dist = new PriorityQueue<>();
		int idx = 4;
		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < n; j++) {
				char tmp = str.charAt(j);
				if (tmp == 'S') {
					maze[i][j] = 3;
					list.add(new Point(3, i, j, 0));
				} else if (tmp == 'K') {
					maze[i][j] = idx;
					list.add(new Point(idx, i, j, 0));
					idx++;
				} else {
					maze[i][j] = Integer.parseInt(tmp + "");
				}
			}
		}
		
		parent = new int[idx];
		
		for (Point p : list) {
			bfs(p);
		}

		System.out.println(mst());
	}
	
	static int mst() {
		int num = 0;
		int cnt = 0;
		
		while(true) {
			if(dist.isEmpty()) break;
			if(num == m)
				break;
			
			Dist tmp = dist.poll();
			if(union(tmp.v1, tmp.v2)) {
				cnt += tmp.val;
				num++;
			}
		}
		
		if(num != m)
			return -1;
		return cnt;
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) 
			return false;
		else
			parent[a] = b;
		
		return true;
	}
	
	static int find(int a) {
		if(parent[a] == 0) 
			return parent[a] = a;
		if(parent[a] == a)
			return parent[a];
		return parent[a] = find(parent[a]);
	}
	static int bfs(Point p) {
		boolean visit[][] = new boolean[n][n];

		Queue<Point> queue = new LinkedList<>();
		queue.add(p);
		visit[p.row][p.col] = true;
		int v = p.idx;
		int cnt = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			if (tmp.idx > 1 && tmp.idx != v) {
				dist.add(new Dist(v, tmp.idx, tmp.val));
				cnt++;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n)
					continue;
				if (visit[nr][nc] || maze[nr][nc] == 1)
					continue;

				visit[nr][nc] = true;
				queue.add(new Point(maze[nr][nc], nr, nc, tmp.val + 1));
			}
		}
		return cnt;
	}

}
