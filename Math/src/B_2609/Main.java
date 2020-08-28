package B_2609;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int b = input.nextInt();
		
		if(b > a) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		int gcd = getGCD(a, b);
		int lcm = (a*b) / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}	

	static int getGCD(int a, int b) {
		if(b == 0) return a;
		return getGCD(b, a%b);
	}
}
