package Scale_2920;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int prev = input.nextInt();
		int result = 0;

		for (int i = 1; i < 8; i++) {
			int now = input.nextInt();
			if (result == 3)
				continue;

			if (result == 0) {
				if (prev + 1 == now)
					result = 1;
				else if (prev - 1 == now)
					result = 2;
				else
					result = 3;
			}

			else if (result == 1 && prev + 1 != now)
				result = 3;
			else if (result == 2 && prev - 1 != now)
				result = 3;
			prev = now;
		}
		
		switch(result) {
			case 1:
				System.out.print("ascending");
				break;
			case 2:
				System.out.print("descending");
				break;
			case 3:
				System.out.print("mixed");
				break;
		}
	}

}
