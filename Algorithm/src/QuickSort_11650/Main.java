package QuickSort_11650;

import java.util.Scanner;

class Point implements Comparable<Point>{
	int row, col;
	Point(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public int compareTo(Point p) {
		if(this.row < p.row)
			return -1;
		else if(this.row == p.row) {
			if(this.col < p.col)
				return -1;
			else if(this.col == p.col)
				return 0;
		}
		return 1;
	}
}

class Quick{
	public void sort(Point[] data, int start, int end) {
		int right = end;
		int left = start;
		Point pivot = data[(start+end)/2];
		
		do {
			while(data[right].compareTo(pivot) > 0) right--;
			while(data[left].compareTo(pivot) < 0) left++;
			if(left <= right) {
				Point tmp = data[right];
				data[right] = data[left];
				data[left] = tmp;
				right--;
				left++;
			}
		}while(left <= right);
		
		if(start < right) sort(data, start, right);
		if(end > left) sort(data, left, end);
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		Point[] data = new Point[n];
		
		for(int i=0; i<n; i++)
			data[i] = new Point(input.nextInt(), input.nextInt());
		
		Quick quick = new Quick();
		
		quick.sort(data, 0, n-1);
		
		for(int i=0; i<n; i++)
			System.out.println(data[i].row+" "+data[i].col);
	}

}
