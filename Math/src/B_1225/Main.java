package B_1225;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String A = input.next();
		String B = input.next();
		
		long sum = 0;
		
		for(int i=0; i<A.length(); i++) {
			sum += Integer.parseInt(A.charAt(i)+"");
		}
		
		long result = 0;
		for(int i=0; i<B.length(); i++) {
			result += sum * Integer.parseInt(B.charAt(i)+"");
		}
		
		System.out.println(result);
	}

}
