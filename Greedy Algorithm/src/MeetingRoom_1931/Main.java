package MeetingRoom_1931;

import java.util.PriorityQueue;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int start, end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting m) {
		if (this.end < m.end)
			return -1;
		else if (this.end == m.end) {
			if (this.start < m.start)
				return -1;
			else
				return 1;
		} else
			return 1;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		PriorityQueue<Meeting> queue = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			queue.add(new Meeting(input.nextInt(), input.nextInt()));
		}
		
		int cnt = 0;
		int end = 0;
		
		while(true) {
			if(queue.isEmpty()) break;
			
			Meeting temp = queue.poll();
			
			if(end <= temp.start) {
				end = temp.end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
