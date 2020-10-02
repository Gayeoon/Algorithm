package CountingSort_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[10000001];
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1; i<10000001; i++) {
			if(arr[i] > 0) {
				arr[i]--;
				bw.write(i+"\n");
				i--;
			}
		}
		
		br.close();
		bw.close();
	}

}
