package B_3190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Snake {
	int time;
	char dir;

	Snake(int time, char dir) {
		this.time = time;
		this.dir = dir;
	}
}

class Point{
	int row, col;
	Point(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int[] Dr = { 0, 1, 0, -1 };
	static int[] Dc = { 1, 0, -1, 0 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int K = input.nextInt();
		int arr[][] = new int[N][N];

		for (int i = 0; i < K; i++)
			arr[input.nextInt()-1][input.nextInt()-1] = 1;

		int L = input.nextInt();
		Queue<Snake> queue = new LinkedList<>();
		
		for(int i=0; i<L; i++)
			queue.add(new Snake(input.nextInt(), input.next().charAt(0)));
		
		int time = 0;
		int dir = 0;
		int h_row=0, h_col=0;

		Stack<Point> body = new Stack<>();
		body.add(new Point(0, 0));
		
		loop:
		while(true) {
			if(!queue.isEmpty() && time == queue.peek().time) {
				char d = queue.poll().dir;
				if(d == 'L')
					dir--;
				else
					dir++;
				
				if(dir < 0)
					dir = 3;
				else if(dir >= 4)
					dir = 0;
			}
			time++;
			
			h_row += Dr[dir];
			h_col += Dc[dir];
			
			for(int i=0; i<body.size(); i++) {
				if(h_row == body.get(i).row && h_col == body.get(i).col)
					break loop;
			}
			
			body.add(new Point(h_row, h_col));

			if(h_row < 0 || h_row >=N || h_col < 0 || h_col >=N)
				break;

			if(arr[h_row][h_col] == 1) {
				arr[h_row][h_col] = 0;
			}else {
				body.remove(0);
			}
		}
		
		System.out.println(time);
	}

}
