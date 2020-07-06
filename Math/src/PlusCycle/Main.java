package PlusCycle;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int first = n/10;
		int second = n%10;
		int newNum = -1;
		int count = 0;
		
		while(true) {
			if(newNum == n) break;

			newNum = first + second;						
			newNum = newNum%10;
			newNum = Integer.parseInt(second+""+newNum);
			first = newNum/10;
			second = newNum%10;
			count++;
		}
		System.out.println(count);
		
	}

}
