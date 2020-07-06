package SteppingStones;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] stones = {0, 2,4,6,8,10};
		int k = 1;
		Set<Integer> tmp = new TreeSet<>();
		for (int i = 0; i < stones.length; i++)
			tmp.add(stones[i]);

		List<Integer> list = new ArrayList<>(tmp);
		int start = 0;
		int end = list.size() - 1;
		while (true) {
			if (start >= end) {
				System.out.println(list.get(start));
				break;
			}
			int mid = (start + end) / 2;
			int result = jump(stones, k, list.get(mid));

			if (result == 0) {
				System.out.println(list.get(mid));
				break;
			} else if (result < 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}

	static int jump(int[] stones, int k, int mid) {
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < stones.length; i++) {
			stones[i] -= mid;
			if (cnt >= k)
				return -1;
			if (stones[i] < 0) {
				cnt++;
				max = Math.max(max, cnt);
			} else
				cnt = 0;
		}
		if (max == k - 1)
			return 0;
		else
			return 1;
	}
}