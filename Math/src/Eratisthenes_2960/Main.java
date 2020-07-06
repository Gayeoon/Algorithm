package Eratisthenes_2960;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		boolean check[] = new boolean[n + 1];
		int cnt = 0;

		outerloop: while (true) {
			for (int i = 2; i <= n; i++) {
				if (!check[i]) {
					for (int j = i; j <= n; j += i) {
						if (check[j])
							continue;
						check[j] = true;
						cnt++;
						if (cnt == k) {
							System.out.println(j);
							break outerloop;
						}
					}
				}
			}
		}
	}

}
