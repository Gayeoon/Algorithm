package B_10610;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String str = input.next();

		if (!str.contains("0")) {
			System.out.println(-1);
		} else {
			int sum = 0;
			int[] arr = new int[10];
			for(int i=0; i<str.length(); i++) {
				arr[str.charAt(i) - '0']++;
				sum += str.charAt(i) - '0';
			}
			if(sum % 3 != 0)
				System.out.println(-1);
			else {
				StringBuilder sb = new StringBuilder();
				
				for(int i=9; i>=0; i--) {
					if(arr[i] > 0) {
						sb.append(i);
						arr[i]--;
						i++;
					}
				}
				System.out.println(sb);
			}
		}
	}

}
