package TopologicalSort_Workbook;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		int[] prev = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int first = input.nextInt();
			int second = input.nextInt();

			list.get(first).add(second);
			prev[second]++;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 1; i < n + 1; i++) {
			if (prev[i] == 0)
				queue.add(i);
		}

		while (true) {
			if (queue.isEmpty())
				break;

			int temp = queue.poll();

			System.out.print(temp + " ");
			for (int t : list.get(temp)) {
				prev[t]--;

				if (prev[t] == 0) {
					queue.add(t);
				}
			}
		}
	}

}
