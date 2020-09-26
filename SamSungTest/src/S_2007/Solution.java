package S_2007;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = sc.next();
            String pattern = str.charAt(0)+"";
            int idx = 0;
            for(int i=1; i<str.length(); i++){
            	if(pattern.charAt(idx) != str.charAt(i)){
                	pattern = str.substring(0, i+1);
                    idx = 0;
                }else{
                    idx++;
                	if(pattern.length() <= idx)
                        idx = 0;
                }
            }
			sb.append("#"+test_case+" "+pattern.length()+"\n");
		}
        System.out.print(sb);
	}
}