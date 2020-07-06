package TopologicalSort_MusicKOI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int degree[] = new int[n + 1];
		int result[] = new int[n];
		boolean visit[] = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int cnt = input.nextInt();
			int prev = input.nextInt();
			for (int j = 0; j < cnt - 1; j++) {
				int next = input.nextInt();
				list.get(prev).add(next);
				degree[next]++;
				prev = next;
			}

		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < n + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		int idx = 0;
		while (true) {
			if (queue.isEmpty())
				break;
			int temp = queue.poll();
			if (visit[temp])
				continue;
			visit[temp] = true;
			result[idx] = temp;
			idx++;
			for (int t : list.get(temp)) {
				degree[t]--;
				if (degree[t] == 0) {
					queue.add(t);
				}
			}
		}

		if (idx == n) {
			for (int i = 0; i < n; i++) {
				System.out.println(result[i]);
			}
		}

		else {
			System.out.println(0);
		}
	}

}
