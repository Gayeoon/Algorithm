package B_10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int tmp = input.nextInt();
			
			if(tmp == 0)
				stack.pop();
			else
				stack.push(tmp);
		}
		
		int sum = 0;
		for(int i=0; i<stack.size(); i++)
			sum += stack.get(i);
		
		System.out.println(sum);
	}

}
