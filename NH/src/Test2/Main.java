package Test2;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] students = { "1502017 Computer Admin", "1502014 Computer Admin", "1702010 Mechanical Admin",
				"1502017 Computer Probrain", "1703014 Computer Probrain", "1603013 Mechanical Probrain",
				"1502019 Mechanical Probrain", "1902010 Computer Motion", "1305014 Mechanical Motion",
				"1502017 Computer Motion", "1702010 Mechanical Motion" };
		int n = 2; // 학생 수
		int m = 3; // 학번 수
		int k = 2; // 학과 수

		HashMap<String, Integer> club = new HashMap<>();
		HashMap<String, Boolean> id = new HashMap<>();
		HashMap<String, String> info = new HashMap<>();

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		int idx = 0;

		for (int i = 0; i < students.length; i++) {
			String[] temp = students[i].split(" ");

			if (id.containsKey(temp[0]) && id.get(temp[0])) {
				id.put(temp[0], false);
				continue;
			}

			id.put(temp[0], true);
			info.put(temp[0], temp[1]);

			if (club.containsKey(temp[2])) {
				list.get(club.get(temp[2])).add(temp[0]);
			} else {
				club.put(temp[2], idx);
				list.add(new ArrayList<>());
				list.get(idx).add(temp[0]);
				idx++;
			}
		}

		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Boolean> department = new HashMap<>();
			HashMap<String, Boolean> id_num = new HashMap<>();

			int cnt = 0;
			for (int j = 0; j < list.get(i).size(); j++) {
				if (id.get(list.get(i).get(j))) {
					department.put(info.get(list.get(i).get(j)), true);
					id_num.put(list.get(i).get(j).substring(0, 2), true);
					cnt++;
				}
			}

			if (n <= cnt && m <= id_num.size() && k <= department.size())
				result++;
		}

		System.out.println(result);

	}

}
