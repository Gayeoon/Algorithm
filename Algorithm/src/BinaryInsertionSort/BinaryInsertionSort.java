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

		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("input.txt");

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

		for (int i = 1; i < count; i++) {
			int low = 0;
			// 비교할 배열의 가장 작은 인덱스
			int high = i;
			// 비교할 배열의 가장 큰 인덱스
			int m = i / 2;
			// 좌측 배열의 가운데 인덱스 넘버
			int key = array[i];
			// 우측 배열의 첫번째 값
			do {
				if (key > array[m])
					low = m + 1;
				// 앞 배열의 가운데 값보다 key가 클 경우
				// low를 (가운데 인덱스 + 1)로 해준다.
				
				else if (key < array[m])
					high = m;
				// 앞 배열의 가운데 값보다 key가 작을 경우
				// high를 가운데 인덱스로 해준다.
				
				else
					break;
				m = low + ((high - low) / 2);
				// 가운데 인덱스 값을 초기화 한다.
				
			} while (low < high);

			if (m < i) {
				System.arraycopy(array, m, array, m+1, i - m);
				array[m] = key;
				// 들어갈 위치를 찾았으면 그 뒤에 값을 한칸씩 미뤄주고 그 자리에 key의 값을 넣는다.
			}
		}

		long endtime = System.currentTimeMillis();
		// 정렬 알고리즘을 돌린 후 시간을 저장한다.
		
		long time = endtime - starttime;
		// 총 걸린시간을 측정한다. 단위는 ms
		
		System.out.println("걸린시간 : " + time + "ms");

		/* 정렬된 데이터 파일을 만드는 코드 */
		try {
			FileWriter fw = new FileWriter("201502017_output.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			int num = 0;

			while (num != count - 1) {
				bw.append(array[num] + " ");
				num++;
			}
			bw.append(array[num] + "");
			// 마지막 숫자 뒤에는 공백을 넣지 않는다.
			
			bw.flush();
			bw.close();
		} catch (Exception e) {
		}

	}

}
