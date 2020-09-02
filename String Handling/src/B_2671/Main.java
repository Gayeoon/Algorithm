package B_2671;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String str = input.next();

		char[] ch = { '0', '1' };
		int check = 0;
		int idx = 0;
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ch[check]) {
				flag = true;
				break;
			}
			if (check == 0)
				check = 1;
			else
				check = 0;
			idx++;
		}
		if (flag) {
			System.out.println("SUBMARINE");
		} else {
			while(true) {
				if(idx >= str.length())
					break;
				if (str.charAt(idx) != '1' || str.charAt(idx) != '0'|| str.charAt(idx) != '0') {
					System.out.println("NOISE");
					break;
				}	
			}
			if (str.charAt(idx++) != '1' || str.charAt(idx++) != '0'|| str.charAt(idx++) != '0') {
				System.out.println("NOISE");
			}else {
				System.out.println();
			}

		}
	}
}
