package B_4880;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		while (true) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();

			if (a == 0 && b == 0 && c == 0)
				break;

			int ap = b - a;
			
			int gp = 0;
			if(a != 0)
				gp = b / a;
			if (b + ap == c)
				sb.append("AP " + (c + ap) + "\n");
			else
				sb.append("GP " + (c * gp) + "\n");
		}

		System.out.print(sb);
	}

}
