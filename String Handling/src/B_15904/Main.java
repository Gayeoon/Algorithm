package B_15904;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String tmp = input.nextLine();

		String str[] = tmp.split(" ");
		String[] ucpc = { "U", "C", "P", "C" };
		int idx = 0;

		for (int i = 0; i < str.length; i++) {
			if (str[i].contains(ucpc[idx])) {
				int temp = str[i].indexOf(ucpc[idx]);
				if (!(str[i].length() <= temp)) {
					str[i] = str[i].substring(temp + 1);
					i--;
				}
				idx++;
			}

			if (idx >= 4)
				break;
		}

		if (idx == 4)
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");
	}

}
