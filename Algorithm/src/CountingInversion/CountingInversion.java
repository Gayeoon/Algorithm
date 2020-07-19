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
			// 앞의 배열의 가장 큰 값이 뒤의 배열의 가장 작은 값보다 작으면 바로 리턴한다.
		}
		
		int count = 0;
		int i = start;
		int j = mid+1;
		int k = 0;
		
		int[] temp = new int[end-start+1];
		// 임시로 담아둘 배열
		
		while(i<=mid && j<=end) {
			if(array[i]<array[j]) {
				temp[k++] = array[i++];
			}
			else {
				temp[k++] = array[j++];
				count = count + mid-i+1;
			}
			// 둘 중 더 작은 값을 temp 배열에 넣는다.
		}
		if(i<=mid) {
			System.arraycopy(array, i, array, start+k, mid-i+1);
		} // 앞 배열에 남은 원소가 있다면 뒤로 옮겨준다.
		System.arraycopy(temp, 0, array, start, k);
		// temp에 저장한 정렬된 배열을 다시 array 배열로 옮긴다.
		
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[30];
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
			System.out.println("파일 읽기 실패");
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
