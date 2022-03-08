package B_16928;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int now, move;

	Node(int now, int move) {
		this.now = now;
		this.move = move;
	}

	@Override
	public int compareTo(Node n) {
		if (this.move < n.move)
			return -1;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int M = input.nextInt();

		HashMap<Integer, Integer> hash = new HashMap<>();

		for (int i = 0; i < N + M; i++)
			hash.put(input.nextInt(), input.nextInt());

		int[] visit = new int[101];
		Arrays.fill(visit, -1);
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0));
		visit[1] = 0;

		while (true) {
			if (queue.isEmpty())
				break;

			Node tmp = queue.poll();

			if (tmp.now == 100) {
				System.out.println(tmp.move);
				break;
			}

			for (int i = 1; i <= 6; i++) {
				int now = tmp.now + i;

				if (now > 100)
					break;

				if (hash.containsKey(now))
					now = hash.get(now);

				if (visit[now] == -1 || visit[now] > (tmp.move + 1)) {
					visit[now] = tmp.move + 1;
					queue.add(new Node(now, visit[now]));
				}
			}
		}
	}

}
