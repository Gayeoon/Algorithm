package Calculator_1808;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution
{
    static int min;
    static int[] dp;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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