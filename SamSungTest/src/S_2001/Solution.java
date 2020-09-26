package S_2001;

import java.util.Scanner;

class Solution
{
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int M = sc.nextInt();
            
            int arr[][] = new int[N][N];
            
            for(int i=0; i<N; i++){
            	for(int j=0; j<N; j++){
                	arr[i][j] = sc.nextInt();
                }
            }
            
            int max = 0;
            
             for(int i=0; i<=N-M; i++){
            	for(int j=0; j<=N-M; j++){
                	int sum = 0;
                    for(int n=i; n<i+M; n++){
                    	for(int m=j; m<j+M; m++){
                        	sum += arr[n][m];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
			
			sb.append("#"+test_case+" "+max+"\n");
		}
        System.out.print(sb);
	}
}