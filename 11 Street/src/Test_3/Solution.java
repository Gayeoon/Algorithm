package Test_3;

import java.util.stream.Stream;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(12345678));
	}

	public static int solution(int N) {
		if(N == 100000000)
			return N;
		else if(N > 100000000)
			return -1;
		
        // write your code in Java SE 11
        int[] number = Stream.of(String.valueOf(N).split("")).mapToInt(Integer::parseInt).toArray();

        int[] num = new int[10];
        for(int i=0; i<number.length; i++){
            num[number[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i =9; i>=0; i--){
            while(num[i] != 0){
                num[i]--;
                sb.append(i);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
