package MinimumSpanningTree_2211;

import java.util.PriorityQueue;
import java.util.Scanner;

class Network implements Comparable<Network> {
	int v1, v2, val;

	Network(int v1, int v2, int val) {
		this.v1 = v1;
		this.v2 = v2;
		this.val = val;
	}

	@Override
	public int compareTo(Network n) {
		if (this.val <= n.val)
			return -1;
		else
			return 1;
	}

}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		boolean visit[] = new boolean[n + 1];
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int val = input.nextInt();

			arr[v1][v2] = arr[v2][v1] = val;
		}

		PriorityQueue<Network> queue = new PriorityQueue<>();

		queue.add(new Network(1, 0, 0));

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			Network tmp = queue.poll();
			if (visit[tmp.v1])
				continue;
			visit[tmp.v1] = true;

			if (tmp.v2 != 0) {
				sb.append(tmp.v2 + " " + tmp.v1 + "\n");
				cnt++;
			}

			for (int i = 1; i <= n; i++) {
				if (arr[tmp.v1][i] != 0 && !visit[i]) {
					queue.add(new Network(i, tmp.v1, tmp.val + arr[tmp.v1][i]));
				}
			}
		}
		sb.insert(0, cnt + "\n");
		System.out.print(sb);
	}
}
