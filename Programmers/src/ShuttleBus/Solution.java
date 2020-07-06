package ShuttleBus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Solution {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		int n = 1;
		int t = 10;
		int m = 1;
		String[] timetable = { "08:50" };
		String answer = "";
		SimpleDateFormat fm = new SimpleDateFormat("HH:mm", Locale.KOREA);
		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < timetable.length; i++) {
			Date d = fm.parse(timetable[i]);
			long sec = d.getTime();
			list.add(sec);
		}
		list.sort(null);

		int idx = 0;

		Date start = fm.parse("09:00");
		long st = start.getTime();
		long plus = t * 1000 * 60;
		for (int i = 0; i < n - 1; i++) {
			int person = 0;
			while (true) {
				if (person == m)
					break;
				if (st < list.get(idx))
					break;
				idx++;
				person++;
			}
			st += plus;
		}
		if (idx >= list.size() || list.size() - idx < m) {
			System.out.println(fm.format(st));
		} else {
			int finish = idx;
			idx += m - 1;
			while (true) {
				if(idx < finish) {
					System.out.println(fm.format(st));
					break;
				}
				long temp = list.get(idx);
				long minus = 1 * 1000 * 60;
				if(temp - minus <= st) {
					System.out.println(fm.format(temp - minus));
					break;
				}
				idx--;
			}
		}

		System.out.println(answer);
	}
}