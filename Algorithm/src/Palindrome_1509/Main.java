package Palindrome_1509;

import java.util.Scanner;

public class Main {

    public static boolean[][] answerAry;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int n = s.length();
		
	// 이 후 Index 계산을 편하게 하기 위한 방법
        s = " " + s;
        answerAry = new boolean[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            answerAry[i][i] = true;			
        }
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == s.charAt(i+1))
                answerAry[i][i+1] = answerAry[i+1][i] = true;
        }		
		
        makeAnswerAry(s, n);
		
        int[] d = new int[n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(answerAry[j][i]) {
                    if(d[i] == 0 || d[i] > d[j-1] + 1) {
                        d[i] = d[j-1] + 1;
                    }
                }
            }
        }
        System.out.println(d[n]);
    }
    public static void makeAnswerAry(String s, int n) {
        for(int i = 2; i < n; i++) {
            for(int j = 1; j <= n - i; j++) {
                if(s.charAt(j) == s.charAt(j+i) && answerAry[j+1][j+i-1]) {
                    answerAry[j][j+i] = answerAry[j+i][j] = true;
                }	
            }
        }
    }
}