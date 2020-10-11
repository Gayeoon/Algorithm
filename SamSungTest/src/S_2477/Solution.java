package S_2477;

import java.util.PriorityQueue;
import java.util.Scanner;

class Counter implements Comparable<Counter> {
	int idx, time, take, person;

	Counter(int idx, int time, int take, int person) {
		this.idx = idx;
		this.time = time;
		this.take = take;
		this.person = person;
	}

	@Override
	public int compareTo(Counter c) {
		if (this.time < c.time)
			return -1;
		else if (this.time == c.time) {
			if (this.idx < c.idx)
				return -1;
		}
		return 1;
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();

			int[] person = new int[K + 1];
			PriorityQueue<Counter> reception = new PriorityQueue<>();
			PriorityQueue<Counter> repair = new PriorityQueue<>();
			PriorityQueue<Counter> rec_waiting = new PriorityQueue<>();
			PriorityQueue<Counter> rep_waiting = new PriorityQueue<>();

			for (int i = 1; i < N + 1; i++)
				reception.add(new Counter(i, 0, sc.nextInt(), 0));
			for (int i = 1; i < M + 1; i++)
				repair.add(new Counter(i, 0, sc.nextInt(), 0));

			for (int k = 1; k <= K; k++) {
				person[k] = sc.nextInt();
			}

			boolean used[] = new boolean[N+1];
			int idx = 1;
			int time = person[1];
			int result = 0;
			int cnt = 0;
			while (true) {
				for (int i = idx; i <= K; i++) {
					if (person[i] == time)
						rec_waiting.add(new Counter(i, time, 0, i));
					else {
						idx = i;
						break;
					}
				}

				if (reception.peek().time <= time) {
					if (used[reception.peek().idx]) {
						rep_waiting.add(new Counter(reception.peek().idx, time, 0, reception.peek().person));
						used[reception.peek().idx] = false;
					}
					if (!rec_waiting.isEmpty()) {
						Counter rec = reception.poll();
						reception.add(new Counter(rec.idx, time + rec.take, rec.take, rec_waiting.poll().person));
						used[rec.idx] = true;
					}else {
						
					}
				}

				if (repair.peek().time <= time && !rep_waiting.isEmpty()) {
					Counter rep = repair.poll();
					if (rep_waiting.peek().idx == A && rep.idx == B)
						result += rep_waiting.peek().person;
					repair.add(new Counter(rep.idx, time + rep.take, rep.take, rep_waiting.poll().person));
					cnt++;
				}

				if(cnt >= K)
					break;
				time++;
			}
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.print(sb);
	}

}
