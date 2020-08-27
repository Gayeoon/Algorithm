package B_1946;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class Grade implements Comparable<Grade>{
	int document, interview;

	Grade(int d, int i) {
		document = d;
		interview = i;
	}

	@Override
	public int compareTo(Grade g) {
		if(this.document < g.document)
			return -1;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			PriorityQueue<Grade> queue = new PriorityQueue<>();
			Stack<Grade> stack = new Stack<>();			

			int n = input.nextInt();

			for (int i = 0; i < n; i++) {
				queue.add(new Grade(input.nextInt(), input.nextInt()));
			}
			stack.add(queue.poll());
					
			while(true) {
				if(queue.isEmpty()) break;
				if(stack.peek().interview > queue.peek().interview) {
					stack.add(queue.poll());
				}
				else
					queue.poll();
			}
			sb.append(stack.size()+"\n");
		}

		System.out.print(sb);
	}

}
