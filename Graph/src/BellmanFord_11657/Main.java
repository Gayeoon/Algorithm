package BellmanFord_11657;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge {
	int start, end, time;
	Edge(int start, int end, int time){
		this.start = start;
		this.end = end;
		this.time = time;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		long dist[] = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		ArrayList<Edge> list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			list.add(new Edge(input.nextInt(), input.nextInt(), input.nextInt()));
		}
		boolean cycle = false;
		
		dist[1] = 0;
		outloop:
		for(int i=1; i<=n; i++) {
			cycle = false;
			for(Edge edge : list) {
				if(dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > dist[edge.start]+ edge.time) {
					dist[edge.end] = dist[edge.start]+ edge.time;
					if(i == n) {
						cycle = true;
						break outloop;
					}
				}
			}
		}
		
		if(cycle) {
			System.out.println(-1);
		}else {
			for(int i=2; i<=n; i++)
				if(dist[i] >= Long.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(dist[i]);
		}
		
	}

}
