package B_2512;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = input.nextInt();
		}
		
		int total = input.nextInt();
		
		Arrays.sort(arr);
		
		int money = 0;
		int cnt = n;
		for(int i=0; i<n; i++) {
			if(cnt * (arr[i]-money) <= total) {
				total -= cnt * (arr[i]-money);
				money = arr[i];
				cnt--;
			}else {
				money += (int)(total / cnt);
				break;
			}
		}
		
		System.out.println(money);
	}

}
