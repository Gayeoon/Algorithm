package CupHolder_2810;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String str = input.next();
		boolean[] check = new boolean[2 * n + 1];
		int idx = 1;
		int cnt = 0;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == 'L') {
				if (flag) {
					check[idx + 1] = true;
				}
				flag = !flag;
			}
			if (!check[idx - 1]) {
				check[idx - 1] = true;
				cnt++;
			} else if (!check[idx + 1]) {
				check[idx + 1] = true;
				cnt++;
			}

			idx += 2;
		}
		System.out.println(cnt);
	}

}
