package B_1717;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
   static int[] parent;

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int m = input.nextInt();

      parent = new int[n + 1];
      Arrays.fill(parent, -1);
      
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < m; i++) {
         int c = input.nextInt();

         int a = find(input.nextInt());
         int b = find(input.nextInt());

         if (a != b) {
            if (c == 0)
               parent[b] = a;
            else
               sb.append("NO\n");
         } else {
            if (c == 1)
               sb.append("YES\n");
         }
      }
      
      System.out.print(sb);

   }

   static int find(int a) {
      if(parent[a] == -1)
         return parent[a] = a;
      
      if(parent[a] == a)
         return a;
      
      return parent[a] = find(parent[a]);
   }
}