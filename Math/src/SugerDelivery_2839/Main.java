package SugerDelivery_2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		if(n % 5 == 0) {
			System.out.print(n/5);
		}
		else{
			int cnt = n/5;
			while(cnt >= 0) {
				int rest = n - (cnt * 5);
				if(rest % 3 == 0) {
					cnt += rest/3;
					break;
				}
				cnt--;
			}
			
			if(cnt < 0)
				System.out.print(-1);
			else
				System.out.print(cnt);
		}
	}
}
