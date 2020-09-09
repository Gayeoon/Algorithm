package B_19591;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Equation implements Comparable<Equation> {
	int idx, val;

	Equation(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}

	@Override
	public int compareTo(Equation e) {
		if (this.val < e.val)
			return -1;
		else if (this.val == e.val)
			return 0;
		else
			return 1;
	}
}

public class Main {
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		PriorityQueue<Equation> queue = new PriorityQueue<>();
		
		// 1 : * / 2 : + -
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			
			switch(tmp) {
			case '*' : case '/':
				queue.add(new Equation(i, 1));
				break;
			case '+' : case '-':
				queue.add(new Equation(i, 2));
				break;
			default:
				list.add(Integer.parseInt(tmp+""));
				break;
			}
		}
		
		while(true) {
			if(list.size() == 1)
				break;
			queue = solve(queue.peek().val, queue);
		}
	}
	
	static PriorityQueue<Equation> solve(int val, PriorityQueue<Equation> queue) {
		PriorityQueue<Equation> result = new PriorityQueue<>();
		
		return result;
	}

}
