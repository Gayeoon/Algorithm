package Rope;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int temp = input.nextInt();
			queue.add(temp);
			max = Math.max(max, temp);
		}
		
		while(true) {
			if(queue.isEmpty())
				break;
			
			max = Math.max(max, queue.peek() * queue.size());
			queue.poll();
		}
		
		System.out.println(max);
	}

}
