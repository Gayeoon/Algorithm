package Test1;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;

		int[] answer = new int[2];
		int arr[][] = new int[2][10];
		Arrays.fill(arr[0], N);
		Arrays.fill(arr[1], 1);
		
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 2; i < 10; i++) {
				if (arr[0][i] == 0)
					continue;
				flag = true;
				int tmp = arr[0][i] / i;
				if (tmp != 0) {
					arr[1][i] *= arr[0][i] % i;
					arr[0][i] = tmp;
				} else {
					arr[1][i] *= arr[0][i];
					arr[0][i] = 0;
					if (answer[1] < arr[1][i]) {
						answer[0] = i;
						answer[1] = arr[1][i];
					} else if (answer[1] == arr[1][i]) {
						if (answer[0] < i) {
							answer[0] = i;
							answer[1] = arr[1][i];
						}
					}
				}
			}
		}

		System.out.println(answer[0] + " " + answer[1]);
	}

}
