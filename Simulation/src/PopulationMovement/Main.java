package PopulationMovement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dot {
	int r, c, val;

	Dot(int r, int c, int val) {
		this.r = r;
		this.c = c;
		this.val = val;
	}
}

public class Main {
	static int arr[][];
	static boolean visit[][];
	static int N, R, L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		R = input.nextInt();
		L = input.nextInt();
		int count = 0;
		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] = input.nextInt();

		boolean flag = false;
		while (true) {
			flag = false;
			Queue<Dot> queue = new LinkedList<Dot>();
			for (int k = 0; k < N; k++)
				Arrays.fill(visit[k], false);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						queue.add(new Dot(i, j, arr[i][j]));
						if (move(queue))
							flag = true;
					}
				}
			}
			if(!flag) break;
			count++;
		}
		System.out.println(count);

	}


	static boolean move(Queue<Dot> queue) {
		int Dr[] = { -1, 1, 0, 0 };
		int Dc[] = { 0, 0, -1, 1 };
		int number = 0;
		boolean flag = false;
		
		Queue<Dot> people = new LinkedList<Dot>();

		while (true) {
			if (queue.isEmpty())
				break;

			Dot temp = queue.poll();
			if(visit[temp.r][temp.c]) continue;
			visit[temp.r][temp.c] = true;
			number += temp.val;

			people.add(temp);

			for (int i = 0; i < 4; i++) {
				int nr = temp.r + Dr[i];
				int nc = temp.c + Dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])
					continue;
				if (R <= Math.abs(temp.val - arr[nr][nc]) &&  Math.abs(temp.val - arr[nr][nc]) <= L) {
					queue.add(new Dot(nr, nc, arr[nr][nc]));
					//System.out.println(temp.val +" ---> "+arr[nr][nc]);
					flag = true;
				}}
			
		}
		//System.out.println("\n\n");
		
		int num = number / people.size();
		while (true) {
			if (people.isEmpty())
				break;
			if(!flag) break;
			Dot temp = people.poll();

			arr[temp.r][temp.c] = num;
		}

		if (number != 0 && flag)
			return true;
		else
			return false;
	}
}
