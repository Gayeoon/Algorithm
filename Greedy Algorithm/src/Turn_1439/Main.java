package Turn_1439;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		int black = 0;
		int white = 0;
		boolean flag;
		char prev = str.charAt(0);
		
		if(prev == '0') {
			flag = true;
			black++;
		}else {
			flag = false;
			white++;
		}
		
		for(int i=1; i<str.length(); i++) {
			if(prev == str.charAt(i)) continue;
			prev = str.charAt(i);
			if(flag) {
				white++;
				flag = false;
			}else {
				black++;
				flag = true;
			}
		}
		
		if(black < white)
			System.out.println(black);
		else
			System.out.println(white);
	}

}
