package Intern_2875;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		
		int surplus = 0;
		int team = 0;
		
		if(n % 2 != 0) {
			n--;
			surplus++;
		}
		if(n/2 < m) {
			int tmp = m-(n/2);
			m -= tmp;
			surplus += tmp;
		}else if(n/2 > m) {
			int tmp = n - (2*m);
			n -= tmp;
			surplus += tmp;
		}
		team = m;
		while(true) {
			if(surplus >= k)
				break;
			team--;
			surplus += 3;
			n -= 2;
			m--;
		}
		
		System.out.println(team);
	}

}
