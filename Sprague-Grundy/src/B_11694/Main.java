package B_11694;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int rock[] = new int[n];
		int num = 0;
		int nim = 0;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			rock[i] = input.nextInt();

			if (rock[i] != 1)
				flag = true;
			else
				num++;
			nim ^= rock[i];
		}

		if (!flag) {
			System.out.print((num % 2 == 1) ? "cubelover" : "koosaga");
		} else if (num != 0) {
			if (num % 2 == 1 && nim != 0)
				System.out.print("koosaga");
			else if (num % 2 == 1 && nim == 0)
				System.out.print("cubelover");
			else if (num % 2 == 0) {
				nim = 0;
				for (int i = 0; i < n; i++) {
					if (flag && rock[i] == 1) {
						nim ^= 1;
						flag = false;
						continue;
					}
					nim ^= rock[i];
				}

				System.out.print(nim == 0 ? "cubelover" : "koosaga");
			}
		} else {
			System.out.print(nim == 0 ? "cubelover" : "koosaga");
		}

	}
}
