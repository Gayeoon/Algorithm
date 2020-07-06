package CandleEvent_9843;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
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