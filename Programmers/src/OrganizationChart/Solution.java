package OrganizationChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Money implements Comparable<Money> {
	int idx, val;

	Money(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}

	@Override
	public int compareTo(Money m) {
		if (this.val < m.val)
			return -1;
		else
			return 1;
	}
}

public class Solution {
	static ArrayList<ArrayList<Money>> group;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] sales = { 14, 17, 15, 18, 19, 14, 13, 16, 28, 17 };
//		int[][] links = { { 10, 8 }, { 1, 9 }, { 9, 7 }, { 5, 4 }, { 1, 5 }, { 5, 10 }, { 10, 6 }, { 1, 3 },
//				{ 10, 2 } };

		int[] sales = {5, 6, 5, 3, 4};
		int[][] links = {{2,3},{1,4},{2,5},{1,2}};
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= sales.length; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < links.length; i++) {
			list.get(links[i][0]).add(links[i][1]);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		group = new ArrayList<>();
		int idx = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			int tmp = queue.poll();
			if (list.get(tmp).size() == 0)
				continue;

			group.add(new ArrayList<>());
			group.get(idx).add(new Money(tmp, sales[tmp - 1]));

			for (int i : list.get(tmp)) {
				group.get(idx).add(new Money(i, sales[i - 1]));
				queue.add(i);
			}
			idx++;
		}

		boolean check[] = new boolean[sales.length + 1];

		backTracking(0, 0, check);

		System.out.println(min);

	}

	static void backTracking(int idx, int sum, boolean check[]) {
		if (idx >= group.size()) {
			min = Math.min(min, sum);
			return;
		}

		for (Money m : group.get(idx)) {
			if (check[m.idx]) {
				backTracking(idx + 1, sum, check);
			} else {
				check[m.idx] = true;
				backTracking(idx + 1, sum + m.val, check);
				check[m.idx] = false;
			}
		}
	}
}
