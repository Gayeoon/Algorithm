package B_5525;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		String str = input.next();

		StringBuilder s = new StringBuilder("I");
		for (int i = 0; i < n; i++) {
			s.append("OI");
		}

		char[] parent = str.toCharArray();
		char[] pattern = s.toString().toCharArray();

		System.out.println(kmp(parent, pattern));
	}

	static int[] makePi(char[] pattern) {
		int[] pi = new int[pattern.length];
		int j = 0;
		for (int i = 1; i < pattern.length; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static int kmp(char[] parent, char[] pattern) {
		int cnt = 0;
		int[] pi = makePi(pattern);
		int j = 0;

		for (int i = 0; i < parent.length; i++) {
			while (j > 0 && parent[i] != pattern[j]) {
				j = pi[j - 1];
			}

			if (parent[i] == pattern[j]) {
				if (j == pattern.length - 1) {
					cnt++;
					j = pi[j];
				} else
					j++;
			}
		}
		return cnt;
	}

}
