package CharacterExplosion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 시간초과
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    String str = br.readLine();
		    String target = br.readLine(); 

		Stack<Character> stack = new Stack<>();

		if (!str.contains(target))
			System.out.println(str);
		else if(str.length() == target.length()) {
			if(str == target) {
				System.out.println("FRULA");
			}else {
				System.out.println(str);
			}
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				char temp = str.charAt(i);
				stack.push(temp);
				if (temp == target.charAt(target.length() - 1)) {
					if (stack.size() >= target.length()) {
						boolean flag = true;

						for (int j = 0; j < target.length() - 1; j++) {
							if (target.charAt(target.length() - j -1) != stack.get(stack.size() - 1 - j)) {
								flag = false;
								break;
							}
						}
						if (flag) {
							for (int k = 0; k < target.length(); k++) {
								stack.pop();
							}
						}

					}
				}
			}
			StringBuilder sb = new StringBuilder();

			while (true) {
				if (stack.isEmpty())
					break;
				sb.insert(0,stack.pop());
			}

			if (sb.length() == 0)
				System.out.println("FRULA");
			else
				System.out.println(sb);

		}

	}
}