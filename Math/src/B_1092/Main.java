package B_1092;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int N = input.nextInt();
      ArrayList<Integer> crane = new ArrayList<>();

      for(int i=0; i<N; i++)
         crane.add(input.nextInt());
      
      crane.sort(Collections.reverseOrder());
      
      int M = input.nextInt();
      
      ArrayList<Integer> box = new ArrayList<>();
      
      for(int i=0; i<M; i++)
         box.add(input.nextInt());
      
      box.sort(Collections.reverseOrder());
      
      if(crane.get(0) < box.get(0)) {
         System.out.println(-1);
         return;
      }
         
      int cnt = 0;
      while(true) {
         if(box.isEmpty())
            break;
      
         int c_idx = 0;
         int b_idx = 0;
         while(true) {
            if(c_idx >= N || b_idx >= box.size())
               break;
            if(crane.get(c_idx) >= box.get(b_idx)) {
               c_idx++;
               box.remove(b_idx);
            }else
               b_idx++;
         }
         
         cnt++;
      }
      
      System.out.println(cnt);
   }

}