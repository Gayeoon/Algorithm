package IronBar;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

class IronBar {
	int start;
	int end;

	IronBar(int s, int e) {
		start = s;
		end = e;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arrangement = "()(((()())(())()))(())";
		int answer = 0;
		Stack<IronBar> stack = new Stack<>();
		ArrayList<IronBar> array = new ArrayList<>();
		ArrayList<Integer> laser = new ArrayList<>();
		
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				stack.push(new IronBar(i, -1));
			} else {
				IronBar temp = stack.pop();
				if (i - temp.start == 1)
					laser.add(temp.start);
				else {
					int k = i;
					array.add(new IronBar(temp.start, i));
				}
			}
		}

		Iterator<Integer> it = laser.iterator();
		int count = 0;
		while (it.hasNext()) {
			int now = it.next();
			Iterator<IronBar> iron = array.iterator();
			while (iron.hasNext()) {
				IronBar temp = iron.next();
				if (temp.start < now) {
					count++;
				}
				if (temp.end < now) {
					iron.remove();
				}
			}
		}

		if (array.size() != 0) {
			count += array.size();
		}
		System.out.println(count);
	}

}
