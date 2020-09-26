package B_2505;

import java.util.Scanner;

public class Main {
	static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = input.nextInt();

		int idx = 1;
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int cnt = 0;
		boolean flag = true;
		while (cnt < 2) {
			if (idx > n)
				break;
			if (flag) {
				if (arr[idx] != idx) { 
					start = idx;
					flag = false;
				}
				idx++;
			}
			else {
				if(arr[idx] == start) {
					swap(start, idx);
					sb.append(start+" "+idx+"\n");
					flag = true;
					idx = 1;
					cnt++;
				}
				else
					idx++;
			}
		}
		 if (cnt == 1) {
		        System.out.println("1 1");
		        System.out.print(sb.toString());
		    } else if (cnt == 2) {
		        System.out.print(sb.toString());
		    } else {
		        System.out.println("1 1");
		        System.out.println("1 1");
		    }

	}
	
	static void swap(int start, int end) {
		for(int i=0; i<(end-start+1)/2; i++) {
			int tmp = arr[start+i];
			arr[start+i] = arr[end-i];
			arr[end-i] = tmp;
		}
	}

}
