package Test1_1;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String inputString = "if (Count of eggs is 4.) {Buy milk.}";

		int answer = 0;
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < inputString.length(); i++) {
			boolean flag = false;
			char temp = inputString.charAt(i);
			if (temp == ')') {
				for (int l = 0; l < list.size(); l++) {
					if (list.get(l) == '(') {
						list.remove(l);
						answer++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					// return -1;
					System.out.println(-1);
				}
				
			} else if (temp == '}') {
				for (int l = 0; l < list.size(); l++) {
					if (list.get(l) == '{') {
						list.remove(l);
						answer++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					// return -1;
					System.out.println(-1);
				}
			} else if (temp == ']') {
				for (int l = 0; l < list.size(); l++) {
					if (list.get(l) == '[') {
						list.remove(l);
						answer++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					// return -1;
					System.out.println(-1);
				}
			} else if (temp == '>') {
				for (int l = 0; l < list.size(); l++) {
					if (list.get(l) == '<') {
						list.remove(l);
						answer++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					// return -1;
					System.out.println(-1);
				}
			} else if (temp == '(' || temp == '[' || temp == '{' || temp == '<')
				list.add(inputString.charAt(i));
		}
		if (list.size() == 0) {
			// return answer;
			System.out.println(answer);
		} else {
			// return -1;
			System.out.println(-1);
		}
	}
}