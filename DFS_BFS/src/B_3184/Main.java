package B_3184;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static char[][] arr;
	static boolean[][] visit;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	static int sheep = 0, wolf = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		R = input.nextInt();
		C = input.nextInt();

		arr = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = input.next();
			arr[i] = str.toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] || arr[i][j] == '#')
					continue;
				solution(i, j);
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	static void solution(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { row, col });
		visit[row][col] = true;

		int s = 0, w = 0;
		while (true) {
			if (queue.isEmpty())
				break;

			int[] tmp = queue.poll();

			if (arr[tmp[0]][tmp[1]] == 'o')
				s++;
			else if (arr[tmp[0]][tmp[1]] == 'v')
				w++;

			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + Dr[i];
				int nc = tmp[1] + Dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc] || arr[nr][nc] == '#')
					continue;

				visit[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}

		if (s > w)
			sheep += s;
		else
			wolf += w;

	}

}
