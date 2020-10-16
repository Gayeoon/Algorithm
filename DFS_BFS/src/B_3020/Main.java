package B_3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] seok = new int[h+1];
		int[] seok_sum = new int[h+2];
		int[] jong = new int[h+1];
		int[] jong_sum = new int[h+2];

		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(br.readLine());

			if (i % 2 != 0) {
				seok[tmp]++;
			} else {
				jong[tmp]++;
			}
		}


		for (int i = h; i >= 1; i--) {
			seok_sum[i] = seok_sum[i + 1] + seok[i];
			jong_sum[i] = jong_sum[i + 1] + jong[i];
		}

		int min = Integer.MAX_VALUE;
		int idx = 1;
		
		for(int i=1; i<=h; i++) {
			int tmp = seok_sum[i] + jong_sum[h+1-i];
			if(tmp < min) {
				min = tmp;
				idx = 1;
			}else if(tmp == min)
				idx++;
		}
		System.out.println(min + " " + idx);
	}

}
