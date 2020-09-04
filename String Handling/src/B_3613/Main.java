package B_3613;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		boolean flag = true;
		boolean now = false;
		String result = "";
		if (str.contains("_")) {
			if (str.charAt(0) == '_') {
				flag = false;
			} else {
			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				if (tmp >= 'A' && tmp <= 'Z') {
					flag = false;
					break;
				} else if (tmp == '_') {
					if (now) {
						flag = false;
						break;
					}
					now = true;
				} else if (now) {
					result += String.valueOf(tmp).toUpperCase();
					now = false;
				} else {
					result += tmp;
				}
			}
		}
		} else {
			if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
				flag = false;
			} else {
				for (int i = 0; i < str.length(); i++) {
					char tmp = str.charAt(i);
					if (tmp >= 'A' && tmp <= 'Z') {
						result += "_";
						result += String.valueOf(tmp).toLowerCase();
					} else {
						result += tmp;
					}
				}
			}
		}

		if (flag && !now)
			System.out.println(result);
		else
			System.out.println("Error!");
	}

}
