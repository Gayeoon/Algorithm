package LongLIS;

import java.util.Arrays;
import java.util.Scanner;

public class LongLIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];
		int temp[] = new int[n];
		int idx = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = input.nextInt();
		}
		
		Arrays.fill(temp, Integer.MAX_VALUE);
		temp[0] = arr[0];
		
		for(int i=1; i<n; i++) {
			if(temp[idx] < arr[i]) {
				idx++;
				temp[idx] = arr[i];
			} else {
				int len = Arrays.binarySearch(temp, arr[i]);
				
				if(len < 0) {
					len = -(len+1);
					temp[len] = arr[i];
				}
			}
		}
		System.out.println(idx+1);
	}

}
