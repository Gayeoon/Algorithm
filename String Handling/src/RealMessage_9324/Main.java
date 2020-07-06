package RealMessage_9324;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int alpha[] = new int[30];
			String str = input.next();
			boolean flag = true;
			outloop:
			for(int j=0; j<str.length(); j++) {
				char tmp = str.charAt(j);
				if(alpha[tmp - 'A'] == 2) {
					j++;
					if(str.length() == j || tmp != str.charAt(j)) {
						flag = false;
						break outloop;
					}
					alpha[tmp - 'A'] = 0;
				}else
					alpha[tmp - 'A']++;
			}
			if(flag)
				sb.append("OK\n");
			else
				sb.append("FAKE\n");
		}
		System.out.print(sb);
	}

}
