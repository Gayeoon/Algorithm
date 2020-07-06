package Calculator_1808;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int min;
    static int[] dp;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        int answer[] = new int[T];
		for(int test_case = 1; test_case <= T; test_case++)
		{
            min = Integer.MAX_VALUE;
            int[] cal = new int[10];
            for(int i=0; i<10; i++){
            	cal[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            dp = new int[target+1];
            int b = check(cal, target);
            if(b != -1)
	            answer[test_case-1] = b +1;
            else{
                solve(cal, target, target);
            	if(min == Integer.MAX_VALUE)
	                answer[test_case-1] = -1;
            	else
	                answer[test_case-1] = min;
            }
		}
        for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#"+test_case+" "+answer[test_case-1]);
		}


	}
    
    static int solve(int[] cal, int num, int target){
    	int b = check(cal, num);
        if(b != -1) {
        	return b;
        }
        
        int result = 0;       
        for(int i=2; i<(int)Math.sqrt(num)+1; i++){
        	if(num % i == 0){
            	int a = check(cal, i);
                if(a != -1){
                	a++;
                    b = solve(cal, num / i, target);
                    if(b == 0) continue;
                    result = a+b;
                    if(target == num){
                    	min = Math.min(min, result+1);
                    }
                }
            }
        }
        return result;
    }
    
    static int check(int[] cal, int target){
    	int result = 0;
    	if(dp[target] != 0) return dp[target];
        while(true){
            if( target <= 0) break;
        	int div = target % 10;
            if(cal[div] == 0)
                return -1;
            result++;
            target = target / 10;
        }
        return result;
    }
}