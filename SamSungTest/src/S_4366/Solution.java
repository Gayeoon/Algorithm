package S_4366;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Integer> list;
	static int ans = 0;
	static boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			char two[] = sc.next().toCharArray();
			String three[] = sc.next().split("");
			
			list = new ArrayList<>();
			ans = 0;
			flag = false;

			makeTwo("", two, 0, false);
			makeThree("", three, 0, false);
			
			sb.append("#"+test_case+" "+ans+"\n");
		}

		System.out.print(sb);
	}

	static void makeTwo(String str, char[] two, int idx, boolean check) {
		if (idx >= two.length) {
			if (check)
				list.add(Integer.parseInt(str, 2));
			return;
		}
		if (check)
			makeTwo(str + two[idx], two, idx + 1, check);
		else {
			if (two[idx] == '0')
				makeTwo(str + "1", two, idx + 1, true);
			else
				makeTwo(str + "0", two, idx + 1, true);

			makeTwo(str + two[idx], two, idx + 1, check);
		}

	}

	static void makeThree(String str, String[] three, int idx, boolean check) {
		if (idx >= three.length) {
			if (check) {
				if(list.contains(Integer.parseInt(str, 3))) {
					flag = true;
					ans = Integer.parseInt(str, 3);
				}
			}
			return;
		}
		
		if(flag)
			return;
		
		if (check)
			makeThree(str + three[idx], three, idx + 1, check);
		else {
			for(int i=0; i<=2; i++) {
				if(flag)
					return;
				if(three[idx].equals(i+""))
					continue;
				makeThree(str + i, three, idx + 1, true);
			}
			if(flag)
				return;
			makeThree(str + three[idx], three, idx + 1, false);
		}
	}
}
