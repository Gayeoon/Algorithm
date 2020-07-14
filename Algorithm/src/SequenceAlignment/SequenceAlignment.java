package SequenceAlignment;

import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SequenceAlignment {
	static char x[];
	static char y[];
	static String[][] M;

	public static String sequenceAlignment() {
		int m = x.length;
		int n = y.length;
		int mismatch = 0;
		int gap = 1;
		int min = 0;
		int count = 0;

		M = new String[2 * (m + 1)][2 * (n + 1)];

		for (int i = 0; i < 2 * (m + 1); i++) {
			for (int j = 0; j < 2 * (n + 1); j++) {
				M[i][j] = "";
			}
		}

		for (int i = 0; i < m + 1; i++) {
			M[2 * i][0] = String.valueOf(i);
		}

		for (int j = 0; j < n + 1; j++) {
			M[0][2 * j] = String.valueOf(j);
		}

		for (int i = 1; i < m + 1; i++) {
			int check = 0;
			for (int j = 1; j < n + 1; j++) {
				if (x[i - 1] == y[j - 1]) {
					mismatch = 0;
				} else {
					mismatch = 2;
				}
				int temp = min(mismatch + Integer.parseInt(M[2*(i - 1)][2*(j - 1)]), gap + Integer.parseInt(M[2*(i - 1)][2*j]), gap + Integer.parseInt(M[2*i][2*(j - 1)]));
				M[2 * i][2 * j] = String.valueOf(temp);

				if (i + count == j) {
					if (i > 1 && j > 2) {
						if (i == j-1 && x[i - 1] == y[j - 2] && x[i-1] != y[j-1]) {
							min = Integer.parseInt(M[2 * i][2 * (j - 1)]);
							M[(2 * i) - 1][(2 * (j - 1))] = "ก่";
							count--;
							check = 1;
						}
					} if (min < Integer.parseInt(M[2 * i][2 * j]) && check == 0) {
						if (x[i - 1] == y[j + count]) {
							min = Integer.parseInt(M[2 * (i - 1)][2 * j]);
							count++;
							M[(2 * i) - 2][(2 * j) - 1] = "ก็";
						} else {
							min = Integer.parseInt(M[2 * i][2 * j]);
							M[(2 * i) - 2][(2 * j) - 1] = "ก็";
							M[(2 * i) - 1][(2 * j)] = "ก่";

						}
					} else if (min == Integer.parseInt(M[2 * i][2 * j])) {
						M[(2 * i) - 1][(2 * j) - 1] = "ขุ";

					}

				}

			}
		}

		return M[2 * m][2 * n];
	}

	private static int min(int i, int j, int k) {
		if (i <= j) {
			if (i < k) {
				return i;
			} else {
				return k;
			}
		} else {
			if (j < k) {
				return j;
			} else {
				return k;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;

		Scanner input = new Scanner(System.in);

		System.out.print("String 1 : ");
		String str1 = input.nextLine();
		x = new char[str1.length()];

		System.out.print("String 2 : ");
		String str2 = input.nextLine();
		y = new char[str2.length()];

		StringTokenizer parser = new StringTokenizer(str1, "");

		while (parser.hasMoreTokens()) {
			String temp = parser.nextToken();

			for (int i = 0; i < temp.length(); i++) {
				x[count] = temp.charAt(i);
				count++;
			}
		}

		count = 0;
		StringTokenizer parser2 = new StringTokenizer(str2, "");

		while (parser2.hasMoreTokens()) {
			String temp = parser2.nextToken();

			for (int i = 0; i < temp.length(); i++) {
				y[count] = temp.charAt(i);
				count++;
			}
		}
		System.out.println("\nMIN COST : " + sequenceAlignment() + "\n");

		System.out.print("\t\t\t\t");
		for (int k = 0; k < y.length; k++) {
			System.out.print(y[k] + "\t\t");
		}
		System.out.println("\n");

		for (int i = 0; i < 2 * (x.length + 1); i++) {
			if (i > 0 && i % 2 == 0) {
				System.out.print(x[(i - 1) / 2] + "\t\t");
			} else {
				System.out.print("  \t\t");
			}
			for (int j = 0; j < 2 * (y.length + 1); j++) {
				System.out.print(M[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
