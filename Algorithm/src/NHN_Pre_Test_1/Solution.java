package NHN_Pre_Test_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int row, col;
	Point(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class Solution {
	static int[][] arr;
	static boolean[][] visit;
	static int n;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		n = input.nextInt();
		arr = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 0 || visit[i][j])
					continue;
				int num = grouping(i, j);
				cnt++;
				list.add(num);
			}
		}
		
		list.sort(null);
		
		System.out.println(cnt);
		if(list.size() != 0) {
			for(int i=0; i<list.size()-1; i++)
				System.out.print(list.get(i)+" ");
			System.out.println(list.getLast());
		}
		
	}
	
	static int grouping(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		visit[row][col] = true;
		queue.add(new Point(row, col));
		int cnt = 1;
		while(true) {
			if(queue.isEmpty())
				break;
			Point tmp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = Dr[i] + tmp.row;
				int nc = Dc[i] + tmp.col;
				
				if(nr <0||nr>=n||nc<0||nc>=n)continue;
				if(visit[nr][nc] || arr[nr][nc] == 0)
					continue;
				
				visit[nr][nc] = true;
				queue.add(new Point(nr, nc));
				cnt++;
			}
		}
		
		return cnt;
	}

}
