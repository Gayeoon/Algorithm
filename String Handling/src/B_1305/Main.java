package B_1305;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String str = input.next();
		char[] pattern = str.toCharArray();
		int pi[] = new int[n];

		int j = 0;
		for (int i = 1; i < n; i++) {
			while (j > 0 && pattern[i] != pattern[j])
				j = pi[j - 1];
			if (pattern[i] == pattern[j]) {
				pi[i] = ++j;
			}
		}

		System.out.println(n - pi[n-1]);

	}

}
