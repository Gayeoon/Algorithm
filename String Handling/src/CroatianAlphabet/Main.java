package CroatianAlphabet;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();
		HashMap<String, Integer> hash = new HashMap<>();
		hash.put("c=", 1);
		hash.put("c-", 1);
		hash.put("dz=", 1);
		hash.put("d-", 1);
		hash.put("lj", 1);
		hash.put("nj", 1);
		hash.put("s=", 1);
		hash.put("z=", 1);

		int count = 0;
		int cnt = 0;
		String prev = "";
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (cnt == 0) {
				if (temp == 'c' || temp == 'd' || temp == 'l' || temp == 'n' || temp == 's' || temp == 'z') {
					prev += temp;
					cnt++;
				} else {
					count++;
				}
			} else {
				prev += temp;
				if (prev.equals("dz")) {
					cnt++;
				} else {
					if (hash.containsKey(prev)) {
						count++;
						cnt = 0;
						prev = "";
					} else {
						count += cnt;
						prev = "" + prev.charAt(cnt);
						cnt = 1;
					}
				}
			}

		}
		System.out.println(count+cnt);
	}

}
