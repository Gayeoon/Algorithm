package Test4;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] dataSource = { { "a", "ddd" }, { "bb" }, { "cc" } };
		String[] tags = { "t" };
		HashMap<String, ArrayList<String>> hash = new HashMap<>();
		HashMap<String, Integer> answer = new HashMap<>();

		for (int i = 0; i < dataSource.length; i++) {
			ArrayList<String> list = new ArrayList<>();
			for (int j = 1; j < dataSource[i].length; j++) {
				list.add(dataSource[i][j]);
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

		String[] ans = new String[answer.size()];
		int idx = 0;
		for (String key : keySetList) {
			ans[idx] = key;

			System.out.println(ans[idx]);
			idx++;
		}
	}
}