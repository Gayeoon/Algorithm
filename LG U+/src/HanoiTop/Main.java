package HanoiTop;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(n).subtract(BigInteger.ONE);

		System.out.println(c);
		if (n <= 20)
			hanoi(n, 1, 2, 3);
	}

	static void hanoi(int n, int start, int mid, int end) {
		if (n == 1) {
			System.out.println(start + " " + end);
			return;
		}
		hanoi(n - 1, start, end, mid);
		System.out.println(start + " " + end);
		hanoi(n - 1, mid, start, end);
	}
}
