package S_1210;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int idx, row, col, dir;
    Point(int idx, int row, int col, int dir){
    	this.idx = idx;
        this.row = row;
        this.col = col;
        this.dir = dir;
    }
}

class Solution
{
	public static void main(String args[]) throws Exception
	{
		int Dr[] = {1, 0, 0};
        int Dc[] = {0, -1, 1};
		Scanner sc = new Scanner(System.in);
		
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= 1; test_case++)
		{
            int T = sc.nextInt();
            
			sb.append("#"+T+" ");
			String[][] arr = new String[100][100];
     		Queue<Point> queue = new LinkedList<>();
            
            for(int i=0; i<100; i++){
            	arr[0][i] = sc.next();
                if(arr[0][i].equals("1")){
                	queue.add(new Point(i, 0, i, 0));
                }
            }
            sc.nextLine();
            for(int i=1; i<100; i++){
            	arr[i] = sc.nextLine().split(" ");
            }
            
            while(true){
            	if(queue.isEmpty())
                    break;
                Point tmp = queue.poll();
                
                if(tmp.row == 99){
                	if(arr[tmp.row][tmp.col].equals("2")){
                    	sb.append(tmp.idx+"\n");
                        break;
                    }
                    continue;
                }
                
                if(tmp.dir == 0){
                    boolean flag = true;
                	for(int i=1; i<3; i++){
                    	int nr = Dr[i]+tmp.row;
                        int nc = Dc[i]+tmp.col;
                        if(nc >= 100 || nc < 0)
                            continue;
                        if(arr[nr][nc].equals("1")){
                        	queue.add(new Point(tmp.idx, nr, nc, i));
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        queue.add(new Point(tmp.idx, tmp.row+1, tmp.col, 0));
                }else{
                	if(arr[tmp.row+1][tmp.col].equals("1"))
                        queue.add(new Point(tmp.idx, tmp.row+1, tmp.col, 0));
					else
                        queue.add(new Point(tmp.idx, tmp.row, tmp.col+Dc[tmp.dir], tmp.dir));                        
                }
            }
                              
		}
        System.out.print(sb);
	}
}