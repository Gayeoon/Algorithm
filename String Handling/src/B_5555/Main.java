package B_5555;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = input.next();
		int n = input.nextInt();
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			String tmp = input.next();
			
			tmp += tmp.substring(0, str.length()-1);
			
			if(tmp.contains(str))
				cnt++;
		}
		
		System.out.print(cnt);
		
	}

}
