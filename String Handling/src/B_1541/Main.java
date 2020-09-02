package B_1541;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.next();

		Stack<Integer> stack = new Stack<>();

		String st = "";
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				if (flag) {
					int tmp = stack.pop();
					tmp += Integer.parseInt(st);
					stack.push(tmp);
					flag = false;
				} else {
					stack.push(Integer.parseInt(st));
				}
				st = "";
			} else if (str.charAt(i) == '+') {
				if (flag) {
					int tmp = stack.pop();
					tmp += Integer.parseInt(st);
					stack.push(tmp);
				} else {
					stack.push(Integer.parseInt(st));
					flag = true;
				}
				st = "";
			} else
				st += str.charAt(i);
		}

		if (flag) {
			int tmp = stack.pop();
			tmp += Integer.parseInt(st);
			stack.push(tmp);
		} else {
			stack.push(Integer.parseInt(st));
		}
		int result = stack.get(0);
		stack.remove(0);

		while (true) {
			if (stack.isEmpty())
				break;

			result -= stack.get(0);
			stack.remove(0);
		}

		System.out.println(result);
	}

}
