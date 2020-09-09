package B_3107;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String str[] = input.next().split(":");

		ArrayList<String> list = new ArrayList<>();
		boolean flag = false;
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals("")) {
				if(flag)
					continue;
				list.add("-1");
				flag = true;
				continue;
			}
			StringBuilder tmp = new StringBuilder();
			for (int j = 0; j < str[i].length(); j++) {
				tmp.append(str[i].charAt(j));
			}
			for (int j = 0; j < 4 - str[i].length(); j++) {
				tmp.insert(0, "0");
			}
			list.add(tmp.toString());
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals("-1")) {
				for(int j=0; j<=8-list.size(); j++)
					sb.append("0000:");
			}
			else
				sb.append(list.get(i)+":");
		}
		if(sb.length() != 40) {
			for(int j=0; j<8-list.size(); j++)
				sb.append("0000:");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}

}
