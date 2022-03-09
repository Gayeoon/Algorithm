package B_13904;

import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
	int more, less;
	Node(int more, int less){
		this.more = more;
		this.less = less;
	}
	
	@Override
	public int compareTo(Node n) {
		if(this.more >= n.more)
			return -1;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		PriorityQueue<Node> date = new PriorityQueue<>();
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		for(int i=0; i<n; i++)
			date.add(new Node(input.nextInt(), input.nextInt()));
		
		int d = date.peek().more;
		int ans = 0;
		
		while(true) {
			if(d <= 0)
				break;
			
			while(true) {
				if(date.isEmpty() || date.peek().more < d)
					break;
				Node tmp = date.poll();
				queue.add(new Node(tmp.less, tmp.more));
			}
			if(!queue.isEmpty())
				ans += queue.poll().more;
			d--;
		}
		
		System.out.println(ans);
	}	

}
