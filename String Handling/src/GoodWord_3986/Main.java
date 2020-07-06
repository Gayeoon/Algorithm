package GoodWord_3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			String str = input.next();
			for(int j=0; j<str.length(); j++) {
				if(stack.isEmpty())
					stack.push(str.charAt(j));
				else if(stack.peek() == str.charAt(j))
					stack.pop();
				else
					stack.push(str.charAt(j));
			}
			
			if(stack.isEmpty())
				cnt++;			
		}
		System.out.println(cnt);
	}

}
