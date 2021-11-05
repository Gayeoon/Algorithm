package B_2533;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] visit;
	static int[] cnt = new int[2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		visit = new int[n + 1];

		for (int i = 0; i <= n; i++)
			list.add(new ArrayList<Integer>());

		for(int i=0; i<n-1; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}

		bfs(1, 1);

		System.out.println(Math.min(cnt[0], cnt[1]));
	}

	static void bfs(int idx, int color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);
		visit[idx] = color;
		cnt[0]++;

		while (true) {
			if (queue.isEmpty())
				break;

			int v = queue.poll();

			for (int i : list.get(v)) {
				if (visit[i] == 0) {
					queue.add(i);
					visit[i] = visit[v] * -1;
					
					if (visit[i] == 1)
						cnt[0]++;
					else
						cnt[1]++;
				}

			}
		}

	}
}
