package B_3568;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String[] str = input.nextLine().split(" ");

		for (int i = 1; i < str.length; i++) {
			String vars = "";
			StringBuffer sb = new StringBuffer();

			int idx = 0;
			while (true) {
				if(idx >= str[i].length()) break;
				
				char tmp = str[i].charAt(idx);

				if (tmp == ',' || tmp == ';')
					break;

				if (tmp >= 'a' && tmp <= 'z')
					vars += tmp;
				else if (tmp >= 'A' && tmp <= 'Z') {
					vars += tmp;
				} else {
					if (tmp == '[') {
						sb.append("][");
						idx++;
					} else
						sb.append(tmp);
				}
				idx++;
			}

			System.out.print(str[0]);
			System.out.print(sb.reverse());
			System.out.println(" " + vars + ";");
		}
	}

}
