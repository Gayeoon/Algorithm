package BreakevenPoint;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();

		int income = c - b;
		int n = 0;
		int now = a;

		if (income <= 0)
			System.out.println(-1);
		else {
			while (true) {
				if (now < 0)
					break;
				now -= income;
				n++;
			}
			System.out.println(n);
		}
	}
}
