package B_1976;

import java.util.Scanner;

public class Main {
   static int[] root;
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int N = input.nextInt();
      int M = input.nextInt();
      
      root = new int[N+1];
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<N; j++) {
            if(input.nextInt() == 1) {
               int a = find(i+1);
               int b = find(j+1);
               
               if(a != b) {
                  if(a <= b)
                     root[b] = a;
                  else
                     root[a] = b;
               }
            }
         }
      }

      boolean flag = true;

      int prev = find(input.nextInt());

      for(int i=1; i<M; i++) {
         if(prev != find(input.nextInt())) {
            flag = false;
            break;
         }
      }
      if(flag)
         System.out.println("YES");
      else
         System.out.println("NO");
   }

   static int find(int a) {
      if(root[a] == 0 || root[a] == a)
         return root[a] = a;
      return root[a] = find(root[a]);
   }
}