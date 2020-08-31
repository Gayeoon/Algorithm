package B_2003;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = input.nextInt();
		
		int start = 0;
		int end = 0;
		int sum = arr[0];
		int cnt = 0;
		
		while (true) {
			if(sum == m) {
				sum -= arr[start];
				start++;
				cnt++;
			}
			
			if(sum <= m) {
				if(end >= n-1)
					break;
				end++;
				sum += arr[end];
				continue;
			}
			if(start >= n-1)
				break;
			sum -= arr[start];
			start++;
		}
		System.out.println(cnt);
	}

}
