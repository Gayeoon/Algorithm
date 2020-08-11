package B_1436;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int idx = 666;
		n--;
		
		while(true) {			
			if(n == 0)
				break;
			idx++;
			
			if((idx+"").contains("666"))
				n--;
		}
		
		System.out.println(idx);
	}

}
