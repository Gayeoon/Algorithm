package B_1924;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int month = input.nextInt();
		int day = input.nextInt();
		
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i=1; i<month; i++) {
			day += days[i-1];
		}
		
		day %= 7;
		
		switch(day) {
			case 1 :
				System.out.println("MON");
				break;
			case 2 :
				System.out.println("TUE");
				break;
			case 3 :
				System.out.println("WED");
				break;
			case 4 :
				System.out.println("THU");
				break;
			case 5 :
				System.out.println("FRI");
				break;
			case 6 :
				System.out.println("SAT");
				break;
			case 0 :
				System.out.println("SUN");
				break;
		}
	}

}
