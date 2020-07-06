package CrossWord_2804;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String A = input.next();
		String B = input.next();

		HashMap<Character, Integer> hash = new HashMap<>();

		for (int i = 0; i < A.length(); i++) {
			if (hash.containsKey(A.charAt(i)))
				continue;
			hash.put(A.charAt(i), i);
		}

		int row = 0, col = 50;

		for (int i = 0; i < B.length(); i++) {
			if (hash.containsKey(B.charAt(i))) {
				if (col > hash.get(B.charAt(i))) {
					row = i;
					col = hash.get(B.charAt(i));
				}
			}
		}
		int idx = 0;
		for (int i = 0; i < B.length(); i++) {
			if (i == row) {
				System.out.println(A);
				idx++;
				continue;
			}
			for (int j = 0; j < A.length(); j++) {
				if (j == col) {
					System.out.print(B.charAt(idx));
					idx++;
				} else
					System.out.print(".");
			}
			System.out.println();
		}
	}

}
