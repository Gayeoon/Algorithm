package ContinuousSum;

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

		int max = arr[0];
		int prev = arr[0];
		for (int i = 1; i < n; i++) {
			if(arr[i] < prev + arr[i]) {
				prev = prev + arr[i];
			}else {
				prev = arr[i];
			}
			max = Math.max(max, prev);
		}
		
		System.out.println(max);
	}

}
