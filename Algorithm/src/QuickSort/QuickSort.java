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
		
		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("10000.txt");
			
			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");
				while (parser.hasMoreTokens()) {
					array[count] = Integer.parseInt(parser.nextToken());
					count++;
					// 데이터를 array 배열에 하나씩 저장한다.
				}
				line = b.readLine();
			}
		} catch (Exception e) {
			System.out.println("주소록 읽기 실패");
		}
		
		long starttime = System.currentTimeMillis();
		// 정렬 알고리즘을 돌리기 전 시간을 저장한다.
		
		quickSort(array, 0, count-1);
		
		long endtime = System.currentTimeMillis();
		// 정렬 알고리즘을 돌린 후 시간을 저장한다.
		
		long time = endtime - starttime;
		// 총 걸린시간을 측정한다. 단위는 ms
		
		System.out.println("걸린시간 : "+time+"ms");

		/* 정렬된 데이터 파일을 만드는 코드 */
		try {
			FileWriter fw = new FileWriter("201502017_quick.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			int num = 0;
			
			while (num != count-1) {
				bw.append(array[num] + " ");
				num++;
			}
			bw.append(array[num]+"");
			// 마지막 숫자 뒤에는 공백을 넣지 않는다.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
		}

	}

}
