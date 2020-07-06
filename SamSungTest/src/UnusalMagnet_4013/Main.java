package UnusalMagnet_4013;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	static int a, b, c, d;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		int[] answer = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			a = b = c = d = 0;
			int n = sc.nextInt();
			int[][] arr = new int[4][8];
			visit = new boolean[4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n; i++) {
				int idx = sc.nextInt();
				int move = sc.nextInt();
				int flag = -1;
				if (move < 0) {
					flag = 1;
					move = move * -1;
				}

				for (int k = 0; k < move; k++) {
					solve(arr, idx - 1, flag);
				}
			}
			int sum = 0;
			if (arr[0][a] == 1)
				sum += 1;
			if (arr[1][b] == 1)
				sum += 2;
			if (arr[2][c] == 1)
				sum += 4;
			if (arr[3][d] == 1)
				sum += 8;
			answer[test_case - 1] = sum;
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}

	static void solve(int[][] arr, int idx, int flag) {
		visit[idx] = true;
		int tmp1, tmp2;
		switch (idx) {
		case 0:
			tmp1 = a+2;
			tmp2 = b+6;
			if(tmp1 > 7) 
				tmp1 -= 8;
			if(tmp2 > 7) 
				tmp2 -= 8;
			
			if (!visit[idx + 1] && arr[idx][tmp1] != arr[idx + 1][tmp2]) {
				solve(arr, 1, -1 * flag);
			}
			a += flag;
			if (a == -1)
				a = 7;
			else if (a == 8)
				a = 0;
			break;
		case 1:
			tmp1 = b+2;
			tmp2 = c+6;
			if(tmp1 > 7) 
				tmp1 -= 8;
			if(tmp2 > 7) 
				tmp2 -= 8;

			if (!visit[idx + 1] && (arr[idx][tmp1] != arr[idx + 1][tmp2])) {
				solve(arr, 2, -1 * flag);
			}
			tmp1 = b+6;
			tmp2 = a+2;
			if(tmp1 > 7) 
				tmp1 -= 8;
			if(tmp2 > 7) 
				tmp2 -= 8;

			if (!visit[idx - 1] && arr[idx][tmp1] != arr[idx - 1][tmp2]) {
				solve(arr, 0, -1 * flag);
			}
			b += flag;
			if (b == -1)
				b = 7;
			else if (b == 8)
				b = 0;
			break;
		case 2:
			tmp1 = c+2;
			tmp2 = d+6;
			if(tmp1 > 7) 
				tmp1 -= 8;
			if(tmp2 > 7) 
				tmp2 -= 8;
			
			if (!visit[idx + 1] && (arr[idx][tmp1] != arr[idx + 1][tmp2])) {
				solve(arr, 3, -1 * flag);
			}
			tmp1 = c+6;
			tmp2 = b+2;
			if(tmp1 > 7) 
				tmp1 -= 8;
			if(tmp2 > 7) 
				tmp2 -= 8;
			if (!visit[idx - 1] && arr[idx][tmp1] != arr[idx - 1][tmp2]) {
				solve(arr, 1, -1 * flag);
			}
			c += flag;
			if (c == -1)
				c = 7;
			else if (c == 8)
				c = 0;
			break;
		case 3:
			tmp1 = d+6;
			tmp2 = c+2;
			if(tmp1 > 7) 
				tmp1 -= 8;
			if(tmp2 > 7) 
				tmp2 -= 8;
		if (!visit[idx - 1] && arr[idx][tmp1] != arr[idx - 1][tmp2]) {
				solve(arr, 2, -1 * flag);
			}
			d += flag;
			if (d == -1)
				d = 7;
			else if (d == 8)
				d = 0;
			break;
		default:
			break;
		}

		visit[idx] = false;
	}
}