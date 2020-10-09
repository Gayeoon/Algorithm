package S_6109;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String str = sc.next();
			int arr[][] = new int[N][N];

			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();

			if (str.equals("up")) {
				for (int j = 0; j < N; j++) {
					Stack<Integer> stack = new Stack<>();
					boolean flag = true;
					for (int i = 0; i < N; i++) {
						if (arr[i][j] == 0)
							continue;
						if (stack.isEmpty())
							stack.push(arr[i][j]);
						else if (flag && stack.peek() == arr[i][j]) {
							stack.pop();
							stack.push(arr[i][j] * 2);
							flag = false;
						} else {
							stack.push(arr[i][j]);
							flag = true;
						}
						arr[i][j] = 0;
					}

					for (int i = 0; i < stack.size(); i++)
						arr[i][j] = stack.get(i);
				}
			} else if (str.equals("down")) {
				for (int j = 0; j < N; j++) {
					Stack<Integer> stack = new Stack<>();
					boolean flag = true;
					for (int i = N - 1; i >= 0; i--) {
						if (arr[i][j] == 0)
							continue;
						if (stack.isEmpty())
							stack.push(arr[i][j]);
						else if (flag && stack.peek() == arr[i][j]) {
							stack.pop();
							stack.push(arr[i][j] * 2);
							flag = false;
						} else {
							stack.push(arr[i][j]);
							flag = true;
						}
						arr[i][j] = 0;
					}

					for (int i = 0; i < stack.size(); i++)
						arr[N - 1 - i][j] = stack.get(i);
				}
			}else if(str.equals("right")) {
				for (int i = 0; i < N; i++) {
					Stack<Integer> stack = new Stack<>();
					boolean flag = true;
					for (int j = N - 1; j >= 0; j--) {
						if (arr[i][j] == 0)
							continue;
						if (stack.isEmpty())
							stack.push(arr[i][j]);
						else if (flag && stack.peek() == arr[i][j]) {
							stack.pop();
							stack.push(arr[i][j] * 2);
							flag = false;
						} else {
							stack.push(arr[i][j]);
							flag = true;
						}
						arr[i][j] = 0;
					}

					for (int j = 0; j < stack.size(); j++)
						arr[i][N-1-j] = stack.get(j);
				}
			}else {
				for (int i = 0; i < N; i++) {
					Stack<Integer> stack = new Stack<>();
					boolean flag = true;
					for (int j = 0; j < N; j++) {
						if (arr[i][j] == 0)
							continue;
						if (stack.isEmpty())
							stack.push(arr[i][j]);
						else if (flag && stack.peek() == arr[i][j]) {
							stack.pop();
							stack.push(arr[i][j] * 2);
							flag = false;
						} else {
							stack.push(arr[i][j]);
							flag = true;
						}
						arr[i][j] = 0;
					}

					for (int j = 0; j < stack.size(); j++)
						arr[i][j] = stack.get(j);
				}
			}

			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}