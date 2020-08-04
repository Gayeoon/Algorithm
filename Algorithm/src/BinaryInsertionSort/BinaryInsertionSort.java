package BinaryInsertionSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class BinaryInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10000000];
		int count = 0;

		/* ������ �о���� �ڵ� */
		try {
			FileReader f = new FileReader("input.txt");

			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");
				while (parser.hasMoreTokens()) {
					array[count] = Integer.parseInt(parser.nextToken());
					count++;
					// �����͸� array �迭�� �ϳ��� �����Ѵ�.
				}
				line = b.readLine();
			}
		} catch (Exception e) {
			System.out.println("�ּҷ� �б� ����");
		}

		long starttime = System.currentTimeMillis();
		// ���� �˰����� ������ �� �ð��� �����Ѵ�.

		for (int i = 1; i < count; i++) {
			int low = 0;
			// ���� �迭�� ���� ���� �ε���
			int high = i;
			// ���� �迭�� ���� ū �ε���
			int m = i / 2;
			// ���� �迭�� ��� �ε��� �ѹ�
			int key = array[i];
			// ���� �迭�� ù��° ��
			do {
				if (key > array[m])
					low = m + 1;
				// �� �迭�� ��� ������ key�� Ŭ ���
				// low�� (��� �ε��� + 1)�� ���ش�.
				
				else if (key < array[m])
					high = m;
				// �� �迭�� ��� ������ key�� ���� ���
				// high�� ��� �ε����� ���ش�.
				
				else
					break;
				m = low + ((high - low) / 2);
				// ��� �ε��� ���� �ʱ�ȭ �Ѵ�.
				
			} while (low < high);

			if (m < i) {
				System.arraycopy(array, m, array, m+1, i - m);
				array[m] = key;
				// �� ��ġ�� ã������ �� �ڿ� ���� ��ĭ�� �̷��ְ� �� �ڸ��� key�� ���� �ִ´�.
			}
		}

		long endtime = System.currentTimeMillis();
		// ���� �˰����� ���� �� �ð��� �����Ѵ�.
		
		long time = endtime - starttime;
		// �� �ɸ��ð��� �����Ѵ�. ������ ms
		
		System.out.println("�ɸ��ð� : " + time + "ms");

		/* ���ĵ� ������ ������ ����� �ڵ� */
		try {
			FileWriter fw = new FileWriter("201502017_output.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			int num = 0;

			while (num != count - 1) {
				bw.append(array[num] + " ");
				num++;
			}
			bw.append(array[num] + "");
			// ������ ���� �ڿ��� ������ ���� �ʴ´�.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
		}

	}

}
