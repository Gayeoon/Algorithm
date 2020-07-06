package Surprising_1972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> answer = new ArrayList<>();
		String line;
		while (!(line = br.readLine()).equals("*")) {
			boolean flag = true;
			outerloop: for (int d = 1; d < line.length()-1; d++) {
				int start = 0;
				List<String> list = new ArrayList<>();
				for (int i = d; i < line.length(); i++) {
					String tmp = line.charAt(start) + "" + line.charAt(i);
					if (list.contains(tmp)) {
						answer.add(line + " is NOT surprising.");
						flag = false;
						break outerloop;
					}
					list.add(tmp);
					start++;
				}
			}
			if (flag) {
				answer.add(line + " is surprising.");
			}

		}
		for(String str : answer) {
			System.out.println(str);
		}
	}

}
