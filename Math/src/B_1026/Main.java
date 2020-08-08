package B_1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = input.nextInt();					
		}

		Arrays.sort(a);
		
		for(int i=0; i<n; i++) {
			b[i] = input.nextInt();		
		}
		
		Arrays.sort(b);
		
		int s = 0;
		
		for(int i=0; i<n; i++) {
			s += a[i] * b[n-i-1];
		}
		
		System.out.println(s);
}

}
