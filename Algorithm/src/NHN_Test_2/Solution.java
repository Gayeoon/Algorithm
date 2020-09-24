package NHN_Test_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		HashMap<String, Integer> hash = new HashMap<>();

		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> keyset = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String str = input.next();

			if (str.equals("enqueue")) {
				String num = input.next();
				list.add(num);
				if (hash.containsKey(num)) {
					int tmp = hash.get(num);
					hash.put(num, tmp + 1);
				} else {
					hash.put(num, 1);
					keyset.add(num);
				}
			} else {
				if (list.size() == 0)
					sb.append(-1 + " ");
				else {
					Collections.sort(keyset, new Comparator<String>() {
						public int compare(String a, String b) {
							if (hash.get(a) > hash.get(b))
								return -1;
							else if (hash.get(a) == hash.get(b)) {
								if (list.indexOf(a) < list.indexOf(b))
									return -1;
								else
									return 1;
							} else
								return 1;
						}
					});

					String key = keyset.get(0);
					sb.append(key + " ");
					int temp = hash.get(key);
					hash.put(key, temp - 1);
					list.remove(key);
				}
			}
		}
		System.out.print(sb);
	}

}
