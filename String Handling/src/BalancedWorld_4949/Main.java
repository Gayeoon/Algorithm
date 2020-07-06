package BalancedWorld_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean flag = true;

		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;

			Stack<Character> stack = new Stack<>();
			flag = true;
			loop: for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);

				switch (tmp) {
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else {
						sb.append("no\n");
						flag = false;
						break loop;
					}
					break;
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else {
						sb.append("no\n");
						flag = false;
						break loop;
					}
					break;
				case '(':
					stack.push('(');
					break;
				case '[':
					stack.push('[');
					break;
				default:
					break;
				}
			}
			if (flag) {
				if (!stack.isEmpty()) {
					sb.append("no\n");
				} else
					sb.append("yes\n");
			}
		}
		System.out.print(sb);
	}

}
