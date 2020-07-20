package B_3047;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num[] = new int[3];
		
		for(int i=0; i<3; i++)
			num[i] = input.nextInt();
		
		Arrays.sort(num);
		
		String str = input.next();
		
		for(int i=0; i<3; i++) {
			System.out.print(num[str.charAt(i)-'A']+" ");
		}
			
	}

}
