package QuickSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class QuickSort {
	
	public static int partition(int[] array, int p, int r) {
		int x = array[r];
		int i = p-1;
		
		for(int j = p; j < r; j++) {
			if(array[j] <= x) {
				i++;
				sort(array, i, j);
			}
		}
		
		i++;
		sort(array, i, r);
		
		return i;
	}
	
	public static void quickSort(int[] array, int p, int r) {
		if(p<r) {
			int q = partition(array, p, r);
			quickSort(array, p, q-1);
			quickSort(array, q+1, r);
		}
		else
			return;
	}

	public static void sort(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[10000000];
		int count = 0;
		
		/* ������ �о���� �ڵ� */
		try {
			FileReader f = new FileReader("10000.txt");
			
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
		
		quickSort(array, 0, count-1);
		
		long endtime = System.currentTimeMillis();
		// ���� �˰����� ���� �� �ð��� �����Ѵ�.
		
		long time = endtime - starttime;
		// �� �ɸ��ð��� �����Ѵ�. ������ ms
		
		System.out.println("�ɸ��ð� : "+time+"ms");

		/* ���ĵ� ������ ������ ����� �ڵ� */
		try {
			FileWriter fw = new FileWriter("201502017_quick.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			int num = 0;
			
			while (num != count-1) {
				bw.append(array[num] + " ");
				num++;
			}
			bw.append(array[num]+"");
			// ������ ���� �ڿ��� ������ ���� �ʴ´�.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
		}

	}

}
