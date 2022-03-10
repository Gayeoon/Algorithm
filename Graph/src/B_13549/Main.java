package B_13549;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int now, cnt;

	Node(int now, int cnt) {
		this.now = now;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Node n) {
		return this.cnt - n.cnt;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();

		int dist[] = new int[100001];
		boolean visit[] = new boolean[100001];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> queue = new PriorityQueue<>();

		queue.add(new Node(N, 0));
		dist[N] = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Node tmp = queue.poll();

			if (visit[tmp.now])
				continue;
			
			visit[tmp.now] = true;
			
			if (tmp.now >= 1 && dist[tmp.now - 1] > tmp.cnt + 1) {
				dist[tmp.now - 1] = tmp.cnt + 1;
				queue.add(new Node(tmp.now - 1, tmp.cnt + 1));
			}

			if (tmp.now < 100000 && dist[tmp.now + 1] > tmp.cnt + 1) {
				dist[tmp.now + 1] = tmp.cnt + 1;
				queue.add(new Node(tmp.now + 1, tmp.cnt + 1));
			}

			if (tmp.now <= 50000 && dist[tmp.now * 2] > tmp.cnt) {
				dist[tmp.now * 2] = tmp.cnt;
				queue.add(new Node(tmp.now * 2, tmp.cnt));
			}
		}
		
		System.out.println(dist[K]);
	}

}
