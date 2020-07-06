package RemoveParentheses;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Paren {
	int right, left;

	Paren(int right, int left) {
		this.right = right;
		this.left = left;
	}
}

class Temp {
	int idx;
	char c;

	Temp(char c, int idx) {
		this.c = c;
		this.idx = idx;
	}
}

public class Main {
	static String str;
	static ArrayList<String> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Paren> paren = new ArrayList<>();
		list = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		str = input.next();

		Stack<Temp> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				while (true) {
					if (stack.isEmpty())
						break;
					Temp t = stack.pop();
					if (t.c == '(') {
						paren.add(new Paren(t.idx, i));
						break;
					}
				}
			} else {
				stack.add(new Temp(str.charAt(i), i));
			}
		}
		boolean[] idx = new boolean[paren.size()];
		print(0, idx, paren);

		list.sort(null);
		list.remove(0);

		for (String st : list) {
			System.out.println(st);
		}

	}

	static void print(int index, boolean[] idx, ArrayList<Paren> paren) {
		if (index == idx.length) {
			boolean[] check = new boolean[str.length()];
			for (int i = 0; i < idx.length; i++) {
				if (idx[i]) {
					check[paren.get(i).left] = true;
					check[paren.get(i).right] = true;
				}
			}
			String st = "";
			for (int s = 0; s < str.length(); s++) {
				if (check[s])
					continue;
				st += str.charAt(s);
			}
			if(!list.contains(st))
				list.add(st);
		} else {
			idx[index] = true;
			print(index + 1, idx, paren);
			idx[index] = false;
			print(index + 1, idx, paren);
		}
	}

}
