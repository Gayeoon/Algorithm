package S_1223;

import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            for(int i=0; i<str.length(); i++){
            	char tmp = str.charAt(i);
                if(!flag){
                	int num = stack.pop();
                    num *= Integer.parseInt(tmp+"");
                    stack.push(num);
                    flag = true;
                    continue;
                }
                if(tmp == '*'){
                	flag = false;
                    continue;
                }
                if(tmp == '+')
                    continue;
                stack.push(Integer.parseInt(tmp+""));
            }
            
            while(true){
                if(stack.isEmpty()) break;
                
                sum += stack.pop();
            }
            
            sb.append("#"+test_case+" "+sum+" \n");
        }
        System.out.print(sb);
	}
}