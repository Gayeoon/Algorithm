package MinimumSpanningTree_Network;

import java.util.PriorityQueue;
import java.util.Scanner;

class Network implements Comparable<Network>{
	int v1, v2, value;
	Network(int v1, int v2, int value){
		this.v1 = v1;
		this.v2 = v2;
		this.value = value;
	}
	
	@Override
	public int compareTo(Network o) {
		if(this.value >= o.value)
			return 1;
		else
			return -1;
	}
}

public class Main {
	static int root[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		
		root = new int[N];
		for(int i=0; i<N; i++) {
			root[i] = i;
		}
		
		PriorityQueue<Network> queue = new PriorityQueue<>();
		
		for(int i=0; i<M; i++) {
			int v1 = input.nextInt()-1;
			int v2 = input.nextInt()-1;
			int value = input.nextInt();
			
			queue.add(new Network(v1, v2, value));
		}
		int n = 0;
		int answer = 0;
		
		while(true) {
			if(queue.isEmpty())
				break;
			if(n == N-1)
				break;
			Network temp = queue.poll();
			
			if(union(temp.v1, temp.v2)) {
				answer += temp.value;
				n++;
			}
		}
		System.out.println(answer);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b)
			return false;
		root[b] = a;
		return true;
	}
	
	static int find(int x) {
		if(x == root[x])
			return x;
		
		return root[x] = find(root[x]);
	}
}
