package Test1_4;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		HashMap<String, Integer> snap = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < snapshots.length; i++) {
			snap.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		for (int i = 0; i < transactions.length; i++) {
			if (list.contains(transactions[i][0]))
				continue;
			list.add(transactions[i][0]);
			if (transactions[i][1].equals("SAVE")) {
				if (snap.containsKey(transactions[i][2])) {
					int t = snap.get(transactions[i][2]);
					snap.put(transactions[i][2], t + Integer.parseInt(transactions[i][3]));
				} else {
					snap.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
				}
			} else {
				if (snap.containsKey(transactions[i][2])) {
					int t = snap.get(transactions[i][2]);
					snap.put(transactions[i][2], t - Integer.parseInt(transactions[i][3]));
				} else {
					snap.put(transactions[i][2], -Integer.parseInt(transactions[i][3]));
				}
			}
		}

		String[][] answer = new String[snap.size()][2];
		TreeMap<String, Integer> tm = new TreeMap<>(snap);
		Iterator<String> iterator = tm.keySet().iterator();

		int idx = 0;
		while (iterator.hasNext()) {
			String key = iterator.next();
			answer[idx][0] = key;
			answer[idx][1] = tm.get(key) + "";
			idx++;
		}

		//return answer;
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i][0]+", "+answer[i][1]);
	}
}