package KMP_2902;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();
		String result = str.charAt(0) + "";
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == '-') {
				result += str.charAt(i+1);
				i++;
			}
		}
		System.out.print(result);
	}

}
