package B_1919;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		char[] a = input.next().toCharArray();
		char[] b = input.next().toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int len = Math.max(a.length, b.length);
		int cnt = 0;
		
		int a_idx = 0, b_idx = 0;
		while(true) {
			if(a_idx >= a.length) {
				cnt += (b.length - b_idx);
				break;
			}

			if(b_idx >= b.length) {
				cnt += (a.length - a_idx);
				break;
			}

			if(a[a_idx] == b[b_idx]) {
				a_idx++;
				b_idx++;
			}
			else if(a[a_idx] < b[b_idx]) {
				a_idx++;
				cnt++;
			}else {
				b_idx++;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
