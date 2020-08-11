package B_1769;

import java.util.Scanner;

public class Main {
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String n = input.next();
		
		if(solve(n)) {
			System.out.println(cnt);
			System.out.println("YES");
		}else {
			System.out.println(cnt);
			System.out.println("NO");
		}
	}

	static boolean solve(String num) {
		if (num.length() == 1) {
			if (Integer.parseInt(num) % 3 == 0)
				return true;
			else
				return false;
		}
		long sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - 48;
		}

		cnt++;
		return solve(sum+"");
	}
}
