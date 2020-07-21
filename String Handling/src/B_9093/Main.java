package B_9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		int n = Integer.parseInt(line);

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			String[] tmp = str.split(" ");

			for (int j = 0; j < tmp.length; j++) {
				String word = (new StringBuffer(tmp[j])).reverse().toString();
				sb.append(word + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
