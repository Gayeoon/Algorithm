package Test1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] C = {2, 4, 3, 6, 1, 10}; // Å¹±¸°ø °ø±Þ
		int[] P = {2, 3, 5, 3, 2, 5}; // Å¹±¸°ø ¼ö¿ä
		
		int day = 1;
		int pay = 100;
		int cnt = 0;
		double result = 0;

		for(int i=0; i<C.length; i++) {
			if(pay < 25)
				break;
			cnt += C[i];
			
			if(cnt < P[i])
				pay /= 2;
			else {
				cnt -= P[i];
				result += P[i] * pay;
				pay = 100;
			}
			
			day++;
				
		}
		
		result = result/day;
		
		System.out.println(Math.round(result*100)/100.0);
	}

}
