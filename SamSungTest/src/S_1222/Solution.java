package S_1222;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextLine();
			String str[] = sc.nextLine().split("\\+");
            int sum = 0;
            
            for(int i=0; i<str.length; i++){
            	sum += Integer.parseInt(str[i]);
            }
            
            sb.append("#"+test_case+" "+sum+" \n");
        }
        System.out.print(sb);
	}
}