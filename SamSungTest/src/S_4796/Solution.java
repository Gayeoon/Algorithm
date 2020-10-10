package S_4796;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        StringBuffer sb = new StringBuffer();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int cnt = 0;
            boolean flag = false;
            int p = 0, n = 0;
            int prev = sc.nextInt();
            for(int i=1; i<N ; i++){
                int now = sc.nextInt();
            	if(prev < now){
                	if(flag){
                    	flag = false;
                        cnt += (p * n);
                        p = 0;
                        n = 0;
                    }
                    p++;
                }else{
                	flag = true;
                    n++;
                }
                
                prev = now;
            }
             cnt += (p * n);
            sb.append("#"+test_case+" "+cnt+"\n");
		}
        System.out.print(sb);
	}
}