package S_1226;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Point {
	int row, col;
    Point(int row, int col){
    	this.row = row;
        this.col = col;
    }
}

class Solution
{
	public static void main(String args[]) throws Exception
	{
        int Dr[] = {-1, 1, 0, 0};
        int Dc[] = {0, 0, -1, 1};
        
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = sc.nextInt();
            sb.append("#"+T+" ");
            char[][] arr = new char[16][16];
            Point start = null, end = null;
            for(int i=0; i<16; i++){
            	String str = sc.next();
                for(int j=0; j<16; j++){
                	arr[i][j] = str.charAt(j);
                    if(arr[i][j] == '2')
                        start = new Point(i, j);
                    else if(arr[i][j] == '3')
                        end = new Point(i, j);
                }
            }
            boolean visit[][] = new boolean[16][16];
            Queue<Point> queue = new LinkedList<>();
            queue.add(start);
            
            visit[start.row][start.col] = true;
            boolean flag = false;
            while(true){
            	if(queue.isEmpty())
                    break;
                Point tmp = queue.poll();
                if(tmp.row == end.row && tmp.col == end.col){
                	flag = true;    
                    break;
            	}
                for(int i=0; i<4; i++){
                	int nr = Dr[i]+tmp.row;
                    int nc = Dc[i]+tmp.col;
                    
                    if(nr<0 || nr >= 16 || nc<0 || nc >= 16) continue;
              		if(visit[nr][nc] || arr[nr][nc] == '1') continue;
                    queue.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
            }
            
            if(flag)
                sb.append(1+"\n");
            else
                sb.append(0+"\n");
		}
        System.out.print(sb);
	}
}