package DigitalTV;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] chenel = new String[n];
		int one = 0, two = 0;
		for (int i = 0; i < n; i++) {
			chenel[i] = sc.next();
			if (chenel[i].equals("KBS1"))
				one = i;
			if (chenel[i].equals("KBS2"))
				two = i;
		}
		int cnt = 0;
		if (one > two) {
			while (true) {
				if (cnt == one)
					break;
				System.out.print(1);
				cnt++;
			}
		}

		for (int i = one; i <= two; i++) {
			cnt--;
			one--;
			System.out.print(4);
		}

		int idx = 1;
		int a = 0;
		while (true) {
			if (cnt == one) {
				idx = 4;
				a = -1;
			}
			if (one == 0)
				break;
			System.out.print(idx);
			cnt++;
			one += a;
		}
		idx = 1;
		a = 0;
		cnt = 0;
		while (true) {
			if (cnt == two) {
				idx = 4;
				a = -1;
			}
			if (two == 1)
				break;
			System.out.print(idx);
			cnt++;
			two += a;

		}

	}

}
