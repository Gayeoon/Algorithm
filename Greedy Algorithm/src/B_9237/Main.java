package B_9237;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String str = input.nextLine();
		String tmp[] = str.split(" ");
		
		int arr[] = Arrays.stream(tmp).mapToInt(Integer :: parseInt).toArray();
		
		Arrays.sort(arr);
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, arr[n - i - 1]+i+1);
		}
		
		System.out.println(max+1);
	}

}
