package B_1747;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int i;
		loop: for (i = n; i < 1004000; i++) {
			if (isPrime(i)) {
				if (isPalindrome((i + "").toCharArray()))
					break loop;
			}
		}
		System.out.println(i);
	}

	static boolean isPrime(int n) {
		if(n == 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static boolean isPalindrome(char[] num) {
		int start = 0;
		int end = num.length - 1;

		while (start < end) {
			if (num[start++] != num[end--])
				return false;
		}
		return true;
	}

}
