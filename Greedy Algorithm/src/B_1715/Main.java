package B_1715;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			queue.add(input.nextInt());
		}
		
		int sum = 0;
		while(true) {
			if(queue.size() <= 1)
				break;
			int tmp = queue.poll() + queue.poll();
			
			sum += tmp;
			queue.add(tmp);
		}
		
		System.out.println(sum);
	}

}
