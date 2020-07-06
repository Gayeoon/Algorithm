package WordSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int i=0; i<n; i++) {
			String temp = input.next();
			if(list.contains(temp)) continue;
			else list.add(temp);
		}
		
		list.sort(new Comparator<String>() {
              @Override
              public int compare(String a, String b) {
                     // TODO Auto-generated method stub
                     int a_len = a.length();
                     int b_len = b.length();
                     if (a_len == b_len) {
                    	 return a.compareTo(b);
                     }
                           
                     else if (a_len > b_len)
                           return 1;
                     else
                           return -1;
              }
       });

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
