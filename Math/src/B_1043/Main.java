package B_1043;

import java.util.Scanner;

public class Main {
   static int root[];
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int N = input.nextInt();
      int M = input.nextInt();
      
      root = new int[N+1];
      boolean[] truth = new boolean[N+1];
      
      int t = input.nextInt();
      for(int i = 0; i<t; i++) {
         truth[input.nextInt()]= true;
      }
      
      int check[] = new int[M];
      for(int i=0; i<M; i++) {
         int num = input.nextInt();
         
         int tmp = input.nextInt();
         check[i] = tmp;
         
         int a = find(tmp);
         
         for(int j=1; j<num; j++) {
            int b = find(input.nextInt());
            
            if(a != b) {
               if(a <= b)
                  root[b] = a;
               else
                  root[a] = b;
               
               if(truth[a] != truth[b])
                  truth[a] = truth[b] = true;
            }
         }
      }
      
      int ans = 0;
      
      for(int i=0; i<M; i++) {
         if(!truth[find(check[i])])
            ans++;
      }
      
      System.out.println(ans);
   }

   static int find(int a) {
      if(root[a] == 0 || root[a] == a)
         return root[a] = a;
      
      return root[a] = find(root[a]);
   }
}