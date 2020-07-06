package MinusNumber_1038;

import java.util.*;

public class Main {
	public static ArrayList getDownNumber(long num, int digit, ArrayList downNumList) {
			
		if(digit > 10) {
			return downNumList;
		}
		
		downNumList.add(num);
		for(int i=0; i<10; i++) {
			if(num%10 > i) {
				getDownNumber((num*10) + i, digit+1, downNumList);
			}
		}
		
		return downNumList;
	}
	
	public static void main(String[] args) {
		
		// �Է� �ޱ� 
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int idx = Integer.parseInt(input);
		
		// �����ϴ� �� ����Ʈ ����� 
		ArrayList<Integer> downNumList = new ArrayList<>();
		
		for(int num=0; num<10; num++) {
			 getDownNumber(num, 1, downNumList);
		}
		
		// ����
		Collections.sort(downNumList);
		
		if(idx >= 1023) {
			System.out.println(-1);
		}
		else {
			System.out.println(downNumList.get(idx));
		}
	}
}