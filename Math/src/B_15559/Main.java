package B_15559;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
   static char[][] arr;
   static boolean[][] visit;
   static int[][] check;
   static HashMap<Character, int[]> hash = new HashMap<>();
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int N = input.nextInt();
      int M = input.nextInt();
      
      arr = new char[N][M];
      check = new int[N][M];
      visit = new boolean[N][M];
      
      for(int i=0; i<N; i++) {
         String str = input.next();
         arr[i] = str.toCharArray();
      }
      
      hash.put('N', new int[] {-1, 0});      
      hash.put('S', new int[] {1, 0});
      hash.put('W', new int[] {0, -1});
      hash.put('E', new int[] {0, 1});

      int ans = 1;
      
      for(int i=0; i<N; i++) {
         for(int j=0; j<M; j++) {
            if(visit[i][j])
               continue;
            int tmp = find(i, j, ans);
            
            if(tmp == ans)
               ans++;
         }
      }
      
      System.out.println(ans-1);
   }

   static int find(int row, int col, int idx) {
      if(check[row][col] != 0)
         return check[row][col];
      
      if(visit[row][col])
         return check[row][col] = idx;
      
      int nr = row + hash.get(arr[row][col])[0];
      int nc = col + hash.get(arr[row][col])[1];
      
      visit[row][col] = true;
      
      return check[row][col] = find(nr, nc, idx);
   }
}