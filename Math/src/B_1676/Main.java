package B_1676;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int cnt = 0;
		
		for(int i=5; i<= n; i *= 5) {
			cnt += n/i;
		}
		System.out.println(cnt);

	}
}
