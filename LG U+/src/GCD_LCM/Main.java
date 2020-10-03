package GCD_LCM;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		int max = 0, min = 0;
		if(n < m) {
			max = m;
			min = n;
		}else {
			max = n;
			min = m;
		}
		
		int r = 1;
		while(r > 0) {
			r = max % min;
			max = min;
			min = r;
		}
		
		System.out.println("GCD(최대공약수) : "+max);
		System.out.println("LCM(최소공배수) : "+((n*m)/max));
	}

}
