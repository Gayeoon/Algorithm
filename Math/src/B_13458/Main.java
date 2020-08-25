package B_13458;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();

		int[] classes = new int[t];

		for (int i = 0; i < t; i++) {
			classes[i] = input.nextInt();
		}

		int B = input.nextInt();
		int C = input.nextInt();

		long cnt = 0;
		for (int i = 0; i < t; i++) {
			if (classes[i] == 0)
				continue;
			classes[i] -= B;
			cnt++;
			if (classes[i] > 0) {
				cnt += classes[i] / C;
				classes[i] %= C;
				if (classes[i] > 0) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

}
