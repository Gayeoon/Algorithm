package Test4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int dp[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String depar = "SEOUL";
		String hub = "DAEGU";
		String dest = "YEOSU";
		String[][] roads = { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
				{ "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
				{ "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
				{ "BUSAN", "YEOSU" } };

		HashMap<String, Integer> hash = new HashMap<>();
		int idx = 0;
		for (int i = 0; i < roads.length; i++) {
			if (!hash.containsKey(roads[i][0])) {
				hash.put(roads[i][0], idx++);
				list.add(new ArrayList<>());
			}

			if (!hash.containsKey(roads[i][1])) {
				hash.put(roads[i][1], idx++);
				list.add(new ArrayList<>());
			}
			list.get(hash.get(roads[i][0])).add(hash.get(roads[i][1]));
		}
		dp = new int[idx];
		int answer = bfs(hash.get(depar), hash.get(hub));
		answer *= bfs(hash.get(hub), hash.get(dest));
		System.out.println(answer % 10007);
	}

	static int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		int cnt = 0;

		while (true) {
			if (queue.isEmpty())
				break;

			int tmp = queue.poll();
			if (tmp == end) {
				cnt++;
			}

			for (int i : list.get(tmp)) {
				queue.add(i);
			}
		}

		return cnt % 10007;
	}
}
