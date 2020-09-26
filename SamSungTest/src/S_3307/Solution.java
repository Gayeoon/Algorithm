package S_3307;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			int idx = 0;
			Arrays.fill(arr, Integer.MAX_VALUE);
			arr[0] = sc.nextInt();
			
			for(int i=1; i<n; i++) {
				int tmp = sc.nextInt();
				
				if(arr[idx] <= tmp)
					arr[++idx] = tmp;
				else {
					int num = Arrays.binarySearch(arr, tmp);
					if(num < 0) {
						num *= -1;
						arr[num-1] = tmp;
					}
				}
			}
			
			sb.append("#"+test_case+" "+(idx+1)+"\n");
		}
		System.out.print(sb);
	}
}