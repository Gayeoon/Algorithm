package SquareNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.valueOf(st.nextToken());
		long max = Long.valueOf(st.nextToken());

		int result = (int) (max - min + 1);
		int sqrt = ((int) Math.sqrt(max));

		boolean[] checks = new boolean[result]; // Á¦°ö ¤¤¤¤¼ö°¡ ¾Æ´ÔÀ» Ã¼Å©. false : Á¦°ö¤¤¤¤¼ö, true : Á¦°ö¤¤¤¤¼ö°¡ ¾Æ´Ô.
		long[] num = new long[result];

		for (long i = 2; i <= sqrt; i++) {
			long squared = i * i;
			long start = min % squared == 0 ? min / squared : (min / squared) + 1;
			for (long j = start; j * squared <= max; j++) { // ¸òÀ» 1¾¿ Áõ°¡½ÃÅ´( j°¡ ¸ò )
				checks[(int) ((j * squared) - min)] = true;
			}
		}

		// Á¦°ö¤¤¤¤¼ö °³¼ö counting
		int count = 0;
		for (int i = 0; i < result; i++) {
			if (!checks[i])
				count++;
		}

		System.out.println(count);
	}

}
