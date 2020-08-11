package B_2776;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = input.nextInt();

		for (int t = 0; t < T; t++) {

			int q = input.nextInt();
			
			arr = new int[q];
			
			for (int i = 0; i < q; i++) {
				arr[i] = input.nextInt();
			}

			Arrays.sort(arr);
			
			int a = input.nextInt();
			for (int i = 0; i < a; i++) {
				int tmp = input.nextInt();

				if (Arrays.binarySearch(arr, tmp) >= 0)
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
		}
		
		System.out.print(sb);
	}

}
