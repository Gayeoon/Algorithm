package S_5356;

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
			char a[] = sc.next().toCharArray();
			char b[] = sc.next().toCharArray();
			char c[] = sc.next().toCharArray();
			char d[] = sc.next().toCharArray();
			char e[] = sc.next().toCharArray();
            
            boolean flag = true;
            int idx = 0;
            String str = "";
            while(flag){
            	flag = false;
                if(a.length > idx){
                	str += a[idx];
                    flag = true;
                }
                if(b.length > idx){
                	str += b[idx];
                    flag = true;
                }
                if(c.length > idx){
                	str += c[idx];
                    flag = true;
                }
                if(d.length > idx){
                	str += d[idx];
                    flag = true;
                }
                if(e.length > idx){
                	str += e[idx];
                    flag = true;
                }
                idx++;
            }
			sb.append("#"+test_case+" "+str+"\n");
		}
        System.out.print(sb);
	}
}