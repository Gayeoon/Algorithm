package FishBread_1860;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		String answer[] = new String[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] guest = new int[n];
			for (int i = 0; i < n; i++) {
				guest[i] = sc.nextInt();
			}
			Arrays.sort(guest);

			if (m > guest[0])
				answer[test_case - 1] = "Impossible";
			else {
				int time = m;
				int index = 0;
				int fish = k;

				while (true) {
					if(index == n) {
						answer[test_case - 1] = "Possible";
						break;
					}
					if (time >= guest[index]) {
						if (fish == 0) {
							answer[test_case - 1] = "Impossible";
							break;
						} else {
							fish--;
							index++;
						}
					}else if(time + m > guest[index]) { 
						if (fish == 0) {
							answer[test_case - 1] = "Impossible";
							break;
						} else {
							fish--;
							index++;
						}
					}else {
						time += m;
						fish += k;
					}
				}

			}
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}
}