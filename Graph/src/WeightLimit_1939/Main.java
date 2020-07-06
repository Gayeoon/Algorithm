package WeightLimit_1939;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Long> list;
	static int end, n;
	static boolean visit[];
	static HashMap[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int m = input.nextInt();
		visit = new boolean[n + 1];
		arr = new HashMap[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new HashMap<Integer, Long>();
		}

		list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			long w = input.nextLong();
			if (arr[v1].containsKey(v2)) {
				int tmp = (int) arr[v1].get(v1);
				arr[v1].put(v2, Math.max(tmp, w));
				arr[v2].put(v1, Math.max(tmp, w));
			} else {
				arr[v1].put(v2, w);
				arr[v2].put(v1, w);
			}
			if (!list.contains(w))
				list.add(w);
		}
		list.sort(null);
		int start = input.nextInt();
		end = input.nextInt();

		long result = search(start, 0, list.size() - 1);
		System.out.println(result);
	}

	static long search(int start, int left, int right) {
		long max = 0;
		if (left <= right) {
			int mid = (left + right) / 2;
			if (dfs(start, list.get(mid))) {
				max = list.get(mid);
				max = Math.max(max, search(start, mid + 1, right));
			} else {
				max = Math.max(max, search(start, left, mid - 1));
			}
		}
		return max;
	}

	static boolean dfs(int start, long weight) {
		if (start == end)
			return true;
		boolean result = false;
		visit[start] = true;
		Iterator<Integer> it = arr[start].keySet().iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (!visit[i]) {
				if ((long) arr[start].get(i) >= weight) {
					result = dfs(i, weight);
				}
			}
		}
		visit[start] = false;
		return result;
	}
}
