package B_1342;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Character> word = new ArrayList<>();
	static int[] num = new int[30];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();

		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (word.contains(tmp)) {
				num[word.indexOf(tmp)]++;
			} else {
				word.add(tmp);
				num[word.indexOf(tmp)]++;
			}
		}
		
		System.out.println(solve(0, str.length(), ' '));
		

	}

	static int solve(int idx, int n, char prev) {
		if (idx == n) {
			return 1;
		}
		int cnt = 0;
		for (int i = 0; i < word.size(); i++) {
			if (num[i] != 0) {
				if (prev != word.get(i)) {
					num[i]--;
					cnt += solve(idx + 1, n, word.get(i));
					num[i]++;
				}
			}
		}
		return cnt;
	}
}
