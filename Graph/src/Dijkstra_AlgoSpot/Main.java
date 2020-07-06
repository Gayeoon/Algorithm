package Dijkstra_AlgoSpot;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Algo implements Comparable<Algo>{
	int row, col, val;
	
	Algo(int r, int c, int v){
		row = r;
		col = c;
		val = v;
	}
	
	@Override
	public int compareTo(Algo o) {
		// TODO Auto-generated method stub
		return this.val > o.val ? 1:-1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		int arr[][] = new int[m][n];
		
		for(int i=0; i<m; i++) {
			String temp = input.next();
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		
		boolean visit[][] = new boolean[m][n];
		int dist[][] = new int[m][n];
		
		for(int i=0; i<m; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		PriorityQueue<Algo> queue = new PriorityQueue<>();
		
		queue.add(new Algo(0,0,0));
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(true) {
			if(queue.isEmpty()) break;
			
			Algo temp = queue.poll();
			
			if(visit[temp.row][temp.col]) continue;
			
			visit[temp.row][temp.col] = true;
			dist[temp.row][temp.col] = temp.val;
			
			for(int i=0; i<4; i++) {
				int nr = temp.row + dr[i];
				int nc = temp.col + dc[i];
				
				if(nr < 0 || nr >= m || nc < 0 || nc >= n ) continue;
				if(visit[nr][nc]) continue;
				
				if(dist[nr][nc] > arr[nr][nc] + dist[temp.row][temp.col]) {
					queue.add(new Algo(nr, nc, arr[nr][nc] + dist[temp.row][temp.col]));
					dist[nr][nc] = arr[nr][nc] + dist[temp.row][temp.col];
				}
				
			}
		}
		
		System.out.println(dist[m-1][n-1]);
	}

}
