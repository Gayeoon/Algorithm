package CountingInversion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class CountingInversion {

	public static int sort_and_count(int[] array, int start, int end) {
	
		if(end-start < 1) {
			return 0;
		}
		
		int mid = (start+end)/2;
		int r1 = sort_and_count(array, start, mid);
		int r2 = sort_and_count(array, mid+1, end);
		int r3 = merge_and_count(array, start, mid, end);
		
		return r1+r2+r3;
	}
	
	public static int merge_and_count(int[] array, int start, int mid, int end) {
		if(array[mid] < array[mid+1]) {
			return 0;
			// ���� �迭�� ���� ū ���� ���� �迭�� ���� ���� ������ ������ �ٷ� �����Ѵ�.
		}
		
		int count = 0;
		int i = start;
		int j = mid+1;
		int k = 0;
		
		int[] temp = new int[end-start+1];
		// �ӽ÷� ��Ƶ� �迭
		
		while(i<=mid && j<=end) {
			if(array[i]<array[j]) {
				temp[k++] = array[i++];
			}
			else {
				temp[k++] = array[j++];
				count = count + mid-i+1;
			}
			// �� �� �� ���� ���� temp �迭�� �ִ´�.
		}
		if(i<=mid) {
			System.arraycopy(array, i, array, start+k, mid-i+1);
		} // �� �迭�� ���� ���Ұ� �ִٸ� �ڷ� �Ű��ش�.
		System.arraycopy(temp, 0, array, start, k);
		// temp�� ������ ���ĵ� �迭�� �ٽ� array �迭�� �ű��.
		
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[30];
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
			System.out.println("���� �б� ����");
		}

		System.out.print("Input Data : ");
		for(int i = 0; i< count; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
				
		int result = sort_and_count(array, 0, count-1);
		
		System.out.println("Output Data : "+result);
		
		
	}

}
