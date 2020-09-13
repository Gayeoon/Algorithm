package Test1_5;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, { "doc4", "t1", "t2", "t4" }, { "doc5", "t6", "t100", "t8" } };
		String[] tags = { "t1", "t2", "t3" };

		HashMap<String, ArrayList<String>> hash = new HashMap<>();
		HashMap<String, Integer> answer = new HashMap<>();

		for (int i = 0; i < dataSource.length; i++) {
			ArrayList<String> list = new ArrayList<>();
			for (int j = 1; j < dataSource[i].length; j++) {
				list.add(dataSource[i][j]);
			}
			if (hash.containsKey(dataSource[i][0])) {
				list.addAll(hash.get(dataSource[i][0]));
				hash.remove(dataSource[i][0]);
			}
			hash.put(dataSource[i][0], list);
		}
		for (int i = 0; i < tags.length; i++) {
			Iterator<String> it = hash.keySet().iterator();

			while (it.hasNext()) {
				String key = it.next();
				if (hash.get(key).contains(tags[i])) {
					if (answer.containsKey(key)) {
						int temp = answer.get(key);
						answer.put(key, temp + 1);
					} else
						answer.put(key, 1);
				}
			}
		}

		ArrayList<String> keySetList = new ArrayList<String>(answer.keySet());

		Collections.sort(keySetList, new Comparator<String>() {

			public int compare(String a, String b) {
				if (answer.get(a) > answer.get(b))
					return -1;
				else if (answer.get(a) == answer.get(b)) {
					return a.compareTo(b);
				} else
					return 1;
			}
		});

		String[] ans;
		if (answer.size() > 10) {
			ans = new String[10];
		} else
			ans = new String[answer.size()];
		int idx = 0;
		for (String key : keySetList) {
			if (idx >= 10)
				break;
			ans[idx] = key;
			idx++;
		}

		// return ans;
		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i]+" ");
	}
}