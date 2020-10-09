package S_4050;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            int cnt = 0;
            int sum = 0;
            for(int i=n-1; i>=0; i--){
                cnt++;
            	if(cnt % 3 == 0)
                    continue;
                sum += arr[i];
            }
			sb.append("#"+test_case+" "+sum+"\n");
		}
        System.out.print(sb);
	}
}