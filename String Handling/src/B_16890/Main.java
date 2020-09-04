package B_16890;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		char apple[] = input.next().toCharArray();
		char cube[] = input.next().toCharArray();
		
		Arrays.sort(apple);
		Arrays.sort(cube);
		
		char ans[] = new char[apple.length];
		
		int turn = 0;
	    int kl = 0, kr = (apple.length + 1) / 2 - 1;
	    int cl = (cube.length + 1) / 2, cr = cube.length - 1;
	    int al = 0, ar = ans.length - 1;
	 
	    while (turn < ans.length) {
	        if ((turn & 1) == 1) { 
	            if (apple[kl] < cube[cr]) { 
	                ans[al] = cube[cr];
	                al++; cr--;
	            }
	            else {
	                ans[ar] = cube[cl];
	                ar--; cl++;
	            }
	        }
	        else { 
	            if (apple[kl] < cube[cr]) {
	                ans[al] = apple[kl];
	                al++; kl++;
	            }
	            else {
	                ans[ar] = apple[kr];
	                ar--; kr--;
	            }
	        }
	        turn++;
	    }
		
		System.out.println(String.valueOf(ans));
		
	}

}
