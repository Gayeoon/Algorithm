package CandleEvent_9843;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution {
	public static void main(String args[]) throws Exception {

//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//		

//        long answer[] = new long[T];
		long prev = ((long)100000 * (long)10000000)-1;
		for (long test_case = (long)100000 * (long)10000000; test_case <= (long)100000 * (long)100000000; test_case++) {
//            long n = sc.nextLong();
			long n = (long) Math.pow(test_case, 2) + test_case;

			long idx = (long) Math.sqrt(n);

			if ((long) Math.pow(idx, 2) + idx == n) {
				long now = idx;
				if(prev + 1 == now)
					prev = now;
				else
					System.out.println(prev+" : "+now);
			}
			
		}
		System.out.println("finish");
	}

}