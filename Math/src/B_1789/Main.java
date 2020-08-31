package B_1789;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		long S = input.nextLong();
		long n = 0;
		long idx = 1;
		while(true) {
			if(S < 0)
				break;
			S -= idx++;
			n++;
		}
		
		System.out.println(n-1);
	}

}
