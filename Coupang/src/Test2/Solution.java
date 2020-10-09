package Test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.text.ParseException;

class Bank implements Comparable<Bank> {
	int idx, cnt;
	long time;

	Bank(int idx, long time, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
		this.time = time;
	}

	@Override
	public int compareTo(Bank b) {
		if (this.time < b.time)
			return -1;
		else if (this.time == b.time)
			if (this.idx < b.idx)
				return -1;
		return 1;
	}
}

public class Solution {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		int n = 3;
		String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };
		PriorityQueue<Bank> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++)
			queue.add(new Bank(i, 0, 0));

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm:ss");

		for (int i = 0; i < customers.length; i++) {
			String[] tmp = customers[i].split(" ");
			String str = tmp[0] + " " + tmp[1];
			Date d = sdf.parse(str);
			long sec = d.getTime() / 1000;
			Bank kiosk = queue.poll();
			long min = Integer.parseInt(tmp[2]) * 60;

			if (kiosk.time <= sec) {
				queue.add(new Bank(kiosk.idx, sec + min, kiosk.cnt + 1));
			} else {
				queue.add(new Bank(kiosk.idx, kiosk.time + min, kiosk.cnt + 1));
			}
		}

		int max = 0;
		while (true) {
			if (queue.isEmpty())
				break;
			max = Math.max(max, queue.poll().cnt);
		}

		System.out.println(max);
	}
}