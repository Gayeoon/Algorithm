package SW_17141;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int row, col, time;
	Point(int row, int col, int time){
		this.row = row;
		this.col = col;
		this.time = time;
	}
	
	@Override
	public int compareTo(Point p) {
		if(this.time < p.time)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int arr[][];
	static int n;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1};
	static LinkedList<Point> list = new LinkedList<>();
	static LinkedList<Point> virus = new LinkedList<>();
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int m = input.nextInt();
		
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				arr[i][j] = input.nextInt();
				if(arr[i][j] == 2) {
					virus.add(new Point(i, j, 0));
					arr[i][j] = 0;
				}
					
			}
		}
		
		solve(0,0,m);
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static void solve(int idx, int cnt, int m) {
		if(cnt == m) {
			result = Math.min(result, moveVirus());
			return;
		}
		if(idx >= virus.size())
			return;
		
		list.add(virus.get(idx));
		solve(idx+1, cnt+1, m);
		list.removeLast();
		solve(idx+1, cnt, m);
	}
	
	static int moveVirus() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		boolean visit[][] = new boolean[n][n];
		
		for(Point p : list) {
			queue.add(p);
			visit[p.row][p.col] = true;
		}
		
		int time = 0;
		while(true) {
			if(queue.isEmpty())
				break;
			Point tmp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];
				
				if(nr<0||nr>=n||nc<0||nc>=n)
					continue;
				if(visit[nr][nc] || arr[nr][nc] == 1)
					continue;
				
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc, tmp.time+1));
			}
			time = Math.max(time, tmp.time);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1)
					continue;
				if(!visit[i][j])
					return Integer.MAX_VALUE;
			}
		}
		return time;
	}
}
