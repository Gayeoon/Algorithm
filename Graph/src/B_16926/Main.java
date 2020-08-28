package B_16926;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();
		int R = input.nextInt();

		int arr[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
			}
		}


		int S = Math.min(n, m)/2;
		
		for(int r=0; r<R; r++) {
			for(int s=0; s<S; s++) {
				int top = s;
				int bottom = n-1-s;
				int right = m-1-s;
				int left = s;
				
				int tmp = arr[s][s];
				for(int i=left; i<right; i++)
					arr[top][i] = arr[top][i+1];
				for(int i=top; i<bottom; i++)
					arr[i][right] = arr[i+1][right];
				for(int i=right; i>left; i--)
					arr[bottom][i] = arr[bottom][i-1];
				for(int i=bottom; i>top; i--) {
					arr[i][left] = arr[i-1][left];
				}
				
				arr[top+1][left] = tmp;
			}			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
