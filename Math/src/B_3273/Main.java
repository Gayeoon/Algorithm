package B_3273;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		int num = input.nextInt();
		int cnt = 0;
		
		int start = 0;
		int end = n-1;
		
		Arrays.sort(arr);
		
		while(true) {
			if(start >= end)
				break;
			
			int sum = arr[start] + arr[end];
			
			if(sum == num) {
				cnt++;
				start++;
			}
			else if(sum < num)
				start++;
			else
				end--;
		}
		
		
		
//		for (int i = 0; i < (1 << n); i++) {
//			if (Integer.bitCount(i) == 2) {
//				int sum = 0;
//				for (int j = 0; j < n; j++) {
//					if ((i & (1 << j)) != 0)
//						sum += arr[j];
//				}
//				if(sum == num)
//					cnt++;
//			}
//		}
		
		System.out.println(cnt);
	}

}
