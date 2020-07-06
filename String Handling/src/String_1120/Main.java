package String_1120;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= b.length() - a.length(); i++) {
			min = Math.min(min, check(a, b.substring(i, i+a.length())));
		}
		System.out.println(min);
	}

	static int check(String a, String b) {
		int cnt = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i))
				cnt++;
		}
		return cnt;
	}
}
