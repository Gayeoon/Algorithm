package B_2661;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		solve(0, n, "");
	}

	static boolean solve(int cnt, int n, String prev) {
		boolean result = true;;
		if (cnt == n) {
			System.out.println(prev);
			return false;
		} else {
			for (int i = 1; i <= 3; i++) {
				if (check(prev+i)) {
					result = solve(cnt + 1, n, prev + i);
				}
				if(!result) return false;
			}
		}
		return result;
	}

	static boolean check(String str) {
		for(int i=1; i<=str.length()/2; i++) {
			String pre = str.substring(str.length()-i-i, str.length()-i);
			String next = str.substring(str.length()-i, str.length());
			
			if(pre.equals(next))
				return false;
		}
		return true;
	}

}
