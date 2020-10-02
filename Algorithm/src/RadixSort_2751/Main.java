package RadixSort_2751;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int minus[] = new int[n];
		int plus[] = new int[n];
		int m_len = 0, p_len = 0;
		int m_idx = 0, p_idx = 0;

		for (int i = 0; i < n; i++) {
			int num = input.nextInt();
			if (num < 0) {
				minus[m_idx++] = num;
				m_len = (int) Math.max(m_len, Math.log10(Math.abs(num)) + 1);
			} else {
				plus[p_idx++] = num;
				p_len = (int) Math.max(p_len, Math.log10(num) + 1);
			}
		}

		m_radixSort(minus, m_len, m_idx);
		radixSort(plus, p_len, p_idx);
		
		System.out.print(sb);
	}

	static void m_radixSort(int[] arr, int len, int max) {
		HashMap<Integer, Queue<Integer>> map = new HashMap<>();

		for (int i = 0; i < 10; i++)
			map.put(i, new LinkedList<Integer>());

		for (int i = 0; i < len; i++) {
			for (int k = 0; k < 10; k++)
				map.get(k).clear();

			for (int j = 0; j < max; j++) {
				int tmp = (int) (Math.abs(arr[j]) / Math.pow(10, i) % 10);
				map.get(tmp).add(arr[j]);
			}

			int idx = 0;
			for (int j = 9; j >= 0; j--) {
				while (true) {
					if (map.get(j).isEmpty())
						break;
					arr[idx++] = map.get(j).poll();
				}
			}
		}

		for (int i = 0; i < max; i++)
			sb.append(arr[i] + "\n");
	}

	static void radixSort(int[] arr, int len, int max) {
		HashMap<Integer, Queue<Integer>> map = new HashMap<>();

		for (int i = 0; i < 10; i++)
			map.put(i, new LinkedList<Integer>());

		for (int i = 0; i < len; i++) {
			for (int k = 0; k < 10; k++)
				map.get(k).clear();

			for (int j = 0; j < max; j++) {
				int tmp = (int) (Math.abs(arr[j]) / Math.pow(10, i) % 10);
				map.get(tmp).add(arr[j]);
			}

			int idx = 0;
			for (int j = 0; j < 10; j++) {
				while (true) {
					if (map.get(j).isEmpty())
						break;
					arr[idx++] = map.get(j).poll();
				}
			}
		}

		for (int i = 0; i < max; i++)
			sb.append(arr[i] + "\n");
	}

}
