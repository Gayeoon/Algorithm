package FBI_2857;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=5; i++) {
			String str = input.next();
			if(str.contains("FBI")) {
				sb.append(i+" ");
			}			
		}
		if(sb.length() == 0) {
			System.out.print("HE GOT AWAY!");
		}else
			System.out.print(sb);
		
	}

}
