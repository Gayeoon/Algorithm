package B_1504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int dot, val;
	
	Node(int dot, int val){
		this.dot = dot;
		this.val = val;
	}
	
	@Override
	public int compareTo(Node n) {
		if(this.val <= n.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		int M = input.nextInt();

		
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}

		int v1 = input.nextInt();
		int v2 = input.nextInt();

		long ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);	
		long ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		if(Math.min(ans1, ans2) >= Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));
	}
	
	static long dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Node> queue = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(true) {
			if(queue.isEmpty())
				break;
			
			Node tmp = queue.poll();
			
			if(visit[tmp.dot])
				continue;
			
			visit[tmp.dot] = true;
			
			for(Node n : list.get(tmp.dot)) {
				if(dist[n.dot] == Integer.MAX_VALUE || dist[n.dot] > tmp.val + n.val) {
					dist[n.dot] = tmp.val + n.val;
					queue.add(new Node(n.dot, dist[n.dot]));
				}
			}
		}
		
		return (long)dist[end];
	}

}
