package B_6581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		StringBuilder sb = new StringBuilder();
		int cnt = 0;

		while ((str = br.readLine()) != null) {
			if (str.equals(""))
				continue;
			String tmp[] = str.split(" |	");

			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].equals("<br>")) {
					sb.append("\n");
					cnt = 0;
				} else if (tmp[i].equals("<hr>")) {
					if (cnt != 0)
						sb.append("\n");
					sb.append("--------------------------------------------------------------------------------\n");
					cnt = 0;
				} else if (tmp[i].equals("")) {
					continue;
				} else {
					if (cnt + tmp[i].length() <= 80) {
						sb.append(tmp[i] + " ");
						cnt += tmp[i].length() + 1;
					} else {
						sb.append("\n" + tmp[i] + " ");
						cnt = tmp[i].length() + 1;
					}
				}
			}

		}

		System.out.print(sb);
	}

}
