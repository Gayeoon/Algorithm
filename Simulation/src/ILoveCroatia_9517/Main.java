package ILoveCroatia_9517;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int n = input.nextInt();
		
		int answer = 0;
		int time = 210;
		
		for(int i=0; i<n; i++) {
			int player = input.nextInt();
			char z = input.next().charAt(0);
			
			if(answer != 0) continue;
			
			if(time - player <= 0) {
				answer = k;
			}else {
				time -= player;
				if(z == 'T') {
					k++;
					if(k == 9)
						k = 1;
				}
			}
		}
		
		System.out.println(answer);
	}

}
