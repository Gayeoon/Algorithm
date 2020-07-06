package InOneLine_1138;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		Arrays.fill(arr, n+1);

		for (int i = 0; i < n; i++) {
			int idx = sc.nextInt();
			int index = 0;
			int cnt = 0;
			while(true) {
				if(idx == cnt && arr[index] == n+1) {
					arr[index] = i+1;
					break;
				}
				if(arr[index] > i)
					cnt++;
				index++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
