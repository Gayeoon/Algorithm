package Test_Two;

import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_Two {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] orders = {"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"};
		HashMap<String, HashMap> hash = new HashMap<>();
		HashMap<String, Integer> user = new HashMap<>();

		for (int i = 0; i < orders.length; i++) {
			String[] str = new String[7];
			str = orders[i].split(" ");
			if (hash.containsKey(str[0])) {
				HashMap<String, Boolean> temp = hash.get(str[0]);
				for (int k = 1; k < str.length; k++) {
					if (temp.containsKey(str[k]))
						continue;
					temp.put(str[k], true);
					int t = user.get(str[0]);
					user.put(str[0], t + 1);
				}
			} else {
				HashMap<String, Boolean> tempHash = new HashMap<>();
				tempHash.put(str[1], true);
				hash.put(str[0], tempHash);
				user.put(str[0], 1);

				HashMap<String, Boolean> temp = hash.get(str[0]);

				for (int k = 1; k < str.length; k++) {
					if (temp.containsKey(str[k]))
						continue;
					temp.put(str[k], true);
					int t = user.get(str[0]);
					user.put(str[0], t + 1);
				}
			}
		}

		Iterator it = sortByValue(hash).iterator();
	    String key = (String) it.next();
	    System.out.print(key);
	    int max = hash.get(key).size();
		
		while (it.hasNext()) {
		    String k = (String) it.next();
		    if(max == hash.get(k).size())
		    	System.out.print(", "+k);
		    else break;
		}
		
		
	}

	public static List sortByValue(final HashMap map) {

		List<Character> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				HashMap v1 = (HashMap) map.get(o1);
				HashMap v2 = (HashMap) map.get(o2);
				
				int t1 = v1.size();
				int t2 = v2.size();
				
				return ((Comparable) t2).compareTo(t1);
			}
		});
		
		return list;
	}

}
