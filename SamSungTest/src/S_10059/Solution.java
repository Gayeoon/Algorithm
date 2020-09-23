package S_10059;

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
            
            int prev = Integer.parseInt(str.substring(0, 2));
            int next = Integer.parseInt(str.substring(2, 4));
			
            boolean flag = true;
            if(prev >= 13 || prev == 0)
                flag = false;
            
            if(next >= 1 && next < 13){
            	if(flag) 
                    sb.append("#"+test_case+" AMBIGUOUS\n");
                else
                    sb.append("#"+test_case+" YYMM\n");
            }else{
            	if(flag) 
                    sb.append("#"+test_case+" MMYY\n");
                else
                    sb.append("#"+test_case+" NA\n");
            }
        }
        System.out.print(sb);
	}
}