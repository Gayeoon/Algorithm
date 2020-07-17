package B_1124;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		int result[] = new int[m+1];
		boolean check[] = new boolean[m+1];
		check[0] = check[1] = true;
		
		for(int i=2; i<=m; i++) {
			if(!check[i]) {
				for(int j=i*2; j<=m; j += i) {
					check[j] = true;
					int num = j;
					while(num % i == 0) {
						num /= i;
						result[j]++;
					}
				}
			}
		}
		int cnt = 0;
		for(int i=n; i<=m; i++) {
			if(!check[result[i]])
				cnt++;
		}
		System.out.println(cnt);
	}
}
