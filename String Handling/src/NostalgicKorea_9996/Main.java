package NostalgicKorea_9996;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		String pattern = input.next();

		String prev = "", next = "";
		int idx = pattern.indexOf("*");

		prev = pattern.substring(0, idx);
		next = pattern.substring(idx + 1, pattern.length());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String str = input.next();
			if(str.length() < prev.length() + next.length()) {
				sb.append("NE\n");
				continue;
			}
				
			if (str.substring(0, prev.length()).equals(prev)) {
				if (str.substring(str.length() - next.length(), str.length()).equals(next)) {
					sb.append("DA\n");
				} else {
					sb.append("NE\n");
				}
			} else {
				sb.append("NE\n");
			}
		}
		System.out.print(sb);

	}

}
