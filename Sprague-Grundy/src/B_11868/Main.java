package B_11868;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int rock[] = new int[n];
		int nim = 0;
		for(int i=0; i<n; i++) {
			rock[i] = input.nextInt();
			nim ^= rock[i];
		}
		
		System.out.print(nim == 0 ? "cubelover" : "koosaga");
		
	}

}
