package B_17413;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		StringBuffer sb = new StringBuffer();

		String str = input.nextLine();

		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				System.out.print(sb.reverse());
				System.out.print('<');
				sb = new StringBuffer();
				flag = true;
			} else if (str.charAt(i) == '>') {
				System.out.print('>');
				flag = false;
			} else if (str.charAt(i) == ' ') {
				System.out.print(sb.reverse());
				System.out.print(" ");
				sb = new StringBuffer();
			} else if (flag) {
				System.out.print(str.charAt(i));
				continue;
			}else {
				sb.append(str.charAt(i));
			}
		}
		System.out.print(sb.reverse());
	}

}
