package SW_15686;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int row, col, dist;
	boolean flag;
	Point(int row, int col, int dist){
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
	Point(int row, int col){
		this.row = row;
		this.col = col;
		this.flag = false;
	}
}
public class Main {
	static int arr[][];
	static int n, result = Integer.MAX_VALUE;
	static LinkedList<Point> list = new LinkedList<>();
	static LinkedList<Point> house = new LinkedList<>();
	static int Dr[] = {-1,1,0,0};
	static int Dc[] = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int m = input.nextInt();
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = input.nextInt();
				if(arr[i][j]== 1)
					house.add(new Point(i, j));
				else if(arr[i][j] == 2)
					list.add(new Point(i,  j));
			}
		}
		
		
		solve(m, 0,0);
		System.out.println(result);
	}

	static void solve(int m, int cnt, int idx) {
		if(cnt == m) {
			result = Math.min(result, chickenDist());
			return;
		}
		if(idx >= list.size())
			return;
		
		list.get(idx).flag = true;
		solve(m, cnt+1, idx+1);
		list.get(idx).flag = false;
		solve(m, cnt, idx+1);
	}
	
	static int chickenDist() {
		Queue<Point> queue = new LinkedList<>();
		
		boolean visit[][] = new boolean[n][n];
		int dp[][] = new int[n][n];
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).flag) {
				queue.add(new Point(list.get(i).row, list.get(i).col, 0));
				visit[list.get(i).row][list.get(i).col] =true;
			}
		}
		
		while(true) {
			if(queue.isEmpty())
				break;
			
			Point tmp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col +Dc[i];
				
				if(nr<0||nr>=n||nc<0||nc>=n)
					continue;
				
				if(!visit[nr][nc] || dp[nr][nc] > tmp.dist+1) {
					dp[nr][nc] = tmp.dist+1;
					visit[nr][nc] = true;
					queue.add(new Point(nr, nc, tmp.dist+1));
				}
			}
		}
		
		int res = 0;
		for(Point p : house) {
			res += dp[p.row][p.col];
		}
		
		return res;
	}
}
