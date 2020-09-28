package S_1289;

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
			String str = sc.next();
           	char flag = '0';
            int cnt = 0;
            for(int i=0; i<str.length(); i++){
            	if(flag == str.charAt(i))
                    continue;
                else{
                	cnt++;
                    flag = str.charAt(i);
                }
            }
            sb.append("#"+test_case+" "+cnt+"\n");
		}
        System.out.print(sb);
	}
}