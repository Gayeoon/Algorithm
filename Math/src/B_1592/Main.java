package B_1592;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int l = input.nextInt();
		
		int arr[] = new int[n];
		
		int idx = 0;
		int cnt = 0;
		while(true) {
			arr[idx]++;
			if(arr[idx] == m)
				break;
			if(arr[idx] % 2 != 0) {
				idx += l;
				if(idx >= n)
					idx -= n;
			}else {
				idx -= l;
				if(idx < 0)
					idx += n;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
