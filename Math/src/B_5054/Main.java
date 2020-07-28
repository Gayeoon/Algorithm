package B_5054;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = input.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = input.nextInt();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int j=0; j<n; j++) {
				int num= input.nextInt();
				
				min = Math.min(min, num);
				max = Math.max(max, num);
			}
			sb.append(((max-min)*2) +"\n");
		}
		
		System.out.print(sb);
	}

}
