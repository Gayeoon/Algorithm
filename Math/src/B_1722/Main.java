package B_1722;

import java.util.Scanner;

public class Main {
	static long[] fac;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int q = input.nextInt();
		fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++)
			fac[i] = fac[i-1] * i;

		boolean visit[] = new boolean[n+1];
		
		if (q == 1) {
			StringBuilder sb = new StringBuilder();
			long m = input.nextLong();
			 for(int i=0; i<n; i++) {
	                for(int j=1; j<=n; j++) {
	                    if(visit[j])
	                        continue;
	                    if(fac[n-i-1] < m) {
	                        m -= fac[n-i-1];
	                    }
	                    else {
	                        sb.append(j+" ");
	                        visit[j] = true;
	                        break;
	                    }
	                }
	            }
			 System.out.print(sb);
		} else {
			long sum = 1;
			for(int i=n-1; i>=0; i--) {
				int tmp = input.nextInt();
				visit[tmp] = true;
				
				for(int k = tmp-1; k>0; k--) {
					if(visit[k]) continue;
					sum += fac[i];
				}
				
			}
			System.out.println(sum);
			
		}
	}


}
