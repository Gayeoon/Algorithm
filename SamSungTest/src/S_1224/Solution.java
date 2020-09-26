package S_1224;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 1; test_case++)
		{
			sc.nextLine();
			char str[] = sc.nextLine().toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			list.add('(');
			list.add(')');
			list.add('+');
			list.add('*');
			Stack<Character> operator = new Stack<>();
            String postfix = "";
            
            for(int i=0; i<str.length; i++) {
            	if(!list.contains(str[i]))
            		postfix += str[i];
            	else {
            		if(str[i] == '(')
            			operator.push('(');
            		else if(str[i] == ')') {
            			while(true) {
            				char tmp = operator.pop();
            				
            				if(tmp == '(')
            					break;
            				postfix += tmp;
            			}
            		}else {
            			while(true) {
            				if(operator.isEmpty())
            					break;
            				if(list.indexOf(operator.peek()) >= list.indexOf(str[i]))
            					postfix += operator.pop();
            				else
            					break;
            			}
            			operator.push(str[i]);
            		}
            	}
            }
            
            while(true) {
            	if(operator.isEmpty()) break;
            	postfix += operator.pop();
            }
            
            Stack<Integer> stack = new Stack<>();
           
            for(int i=0; i<postfix.length(); i++) {
            	char tmp = postfix.charAt(i);
            	if(list.contains(tmp)) {
            		int num = stack.pop();
            		if(tmp == '+')
            			num += stack.pop();
            		else
            			num *= stack.pop();
            		stack.push(num);
            	}else
            		stack.push(Integer.parseInt(tmp+""));
            }
            
            sb.append("#"+test_case+" "+stack.pop()+" \n");
        }
        System.out.print(sb);
	}
}