package S_1208;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 1; test_case++)
		{
            int max = sc.nextInt();
            int[] arr = new int[100];
            for(int i=0; i<100; i++)
                arr[i] = sc.nextInt();
            int cnt = 0;
            
            while(true){
            	Arrays.sort(arr);
            	if(cnt == max)
                    break;
                if(arr[0] == arr[99])
                    break;
                arr[0]++;
                arr[99]--;
                cnt++;
            }
			sb.append("#"+test_case+" "+(arr[99]-arr[0])+"\n");		
		}
        System.out.print(sb);
	}
}