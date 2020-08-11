package B_1769;

import java.util.Scanner;

public class Main {
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		
		if(solve(n)) {
			System.out.println(cnt);
			System.out.println("YES");
		}else {
			System.out.println(cnt);
			System.out.println("NO");
		}
	}

	static boolean solve(int n) {
		if ((int) Math.log10(n) == 0) {
			if (n == 3 || n == 6 || n == 9)
				return true;
			else
				return false;
		}
		int sum = 0;
		for (int i = (int) Math.log10(n); i >= 0; i--) {
			sum += (n / Math.pow(10, i));
			n %= Math.pow(10, i);
		}

		cnt++;
		return solve(sum);
	}
}
