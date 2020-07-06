package WordStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();

		HashMap<Character, Integer> hash = new HashMap<>();

		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (hash.containsKey(temp)) {
				int num = hash.get(temp);
				hash.put(temp, num + 1);
			} else
				hash.put(temp, 1);
		}
		Iterator it = sortByValue(hash).iterator();

		char temp = (char) it.next();			
		int max = hash.get(temp);

		if(it.hasNext()) {
			char tmp = (char) it.next();
			if(max == hash.get(tmp)) {
				System.out.println("?");
			} else {
				System.out.println(temp);
			}
		}else {
			System.out.println(temp);
		}
		

	}
	// 별도의 스태틱 함수로 구현

	public static List sortByValue(final HashMap map) {

		List<Character> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		//Collections.reverse(list); // 주석시 내림차순
		return list;

	}
}
