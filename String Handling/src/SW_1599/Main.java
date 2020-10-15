package SW_1599;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char str[] = { 'a', 'b', 'k', 'd', 'e', 'g', 'h', 'i', 'l', 'm', 'n', 'c', 'o', 'p', 'r', 's', 't', 'u', 'w',
				'y', 'z' };
		HashMap<Character, Integer> hash = new HashMap<>();
		for (int i = 0; i < str.length; i++)
			hash.put(str[i], i);

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String text = input.next();
			if (text.contains("ng"))
				text = text.replace("ng", "c");
			list.add(text);
		}

		list.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				int idx = 0;
				while (true) {
					if (idx >= a.length())
						return -1;
					if (idx >= b.length())
						return 1;

					if (hash.get(a.charAt(idx)) == hash.get(b.charAt(idx))) {
						idx++;
						continue;
					}
					return hash.get(a.charAt(idx)) - hash.get(b.charAt(idx));
				}
			}
		});

		for (String s : list) {
			if (s.contains("c"))
				s = s.replace("c", "ng");
			System.out.println(s);
		}
	}

}
