package B_5063;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int r = input.nextInt();
			int e = input.nextInt();
			int c = input.nextInt();

			int result = (e - c) - r;

			if (result > 0) {
				sb.append("advertise\n");
			} else if (result == 0) {
				sb.append("does not matter\n");
			} else {
				sb.append("do not advertise\n");
			}
		}
		
		System.out.print(sb);
	}
}
