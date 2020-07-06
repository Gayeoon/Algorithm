package CMD;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String s = input.next();
		char[] str = new char[s.length()];

		if (n == 1) {
			System.out.println(s);
		} else {
			for (int i = 0; i < s.length(); i++) {
				str[i] = s.charAt(i);
			}

			for (int i = 0; i < n - 1; i++) {
				s = input.next();
				String temp = "";
				for (int j = 0; j < s.length(); j++) {
					if (str[j] == '?')
						continue;
					if (str[j] != s.charAt(j)) {
						str[j] = '?';
					}
				}
			}
			for (int i = 0; i < s.length(); i++) {
				System.out.print(str[i]);
			}

		}
	}
}
