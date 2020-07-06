package Grasshopper;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODOArrayList<E>erated method stub
		HashMap<Character, String> hash = new HashMap<>();
		int idx = 2;
		int cnt = 1;
		for (char tmp = 'a'; tmp <= 'o'; tmp++) {
			if (cnt == 4) {
				idx++;
				cnt = 1;
			}
			cnt++;
			hash.put(tmp, idx + "" + cnt);
		}
		cnt = 1;
		for (char tmp = 'p'; tmp <= 's'; tmp++) {
			cnt++;
			hash.put(tmp, 7 + "" + cnt);
		}
		cnt = 1;
		for (char tmp = 't'; tmp <= 'v'; tmp++) {
			cnt++;
			hash.put(tmp, 8 + "" + cnt);
		}
		cnt = 1;
		for (char tmp = 'w'; tmp <= 'z'; tmp++) {
			cnt++;
			hash.put(tmp, 9 + "" + cnt);
		}
		Scanner input = new Scanner(System.in);
		int number[] = new int[10];
		for (int i = 1; i <= 9; i++) {
			number[input.nextInt()] = i;
		}
		String str = input.next();
		int pre = 0;
		for (int i = 0; i < str.length(); i++) {
			String st = hash.get(str.charAt(i));
			idx = Integer.parseInt(st.charAt(0) + "");
			int num = Integer.parseInt(st.charAt(1) + "");
			if (idx == pre)
				System.out.print("#");
			for (int k = 1; k < num; k++)
				System.out.print(number[idx]);
			pre = idx;
		}

	}

}
