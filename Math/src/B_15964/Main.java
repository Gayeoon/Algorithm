package B_15964;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		long result = a+b;
		result *= a-b;
		
		System.out.println(result);
	}

}
