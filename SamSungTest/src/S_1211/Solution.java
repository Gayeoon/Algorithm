package S_1211;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;

class Point implements Comparable<Point>{
	int idx, row, col, dir, time;
    Point(int idx, int row, int col, int dir, int time){
    	this.idx = idx;
        this.row = row;
        this.col = col;
        this.dir = dir;
        this.time = time;
    }
    
    @Override
    public int compareTo(Point p){
    	if(this.time < p.time)
            return -1;
        else
            return 1;
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
        
        for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T = sc.nextInt();
            
			sb.append("#"+T+" ");
			String[][] arr = new String[100][100];
     		PriorityQueue<Point> queue = new PriorityQueue<>();
            
            for(int i=0; i<100; i++){
            	arr[0][i] = sc.next();
                if(arr[0][i].equals("1")){
                	queue.add(new Point(i, 0, i, 0, 1));
                }
            }
            sc.nextLine();
            for(int i=1; i<100; i++){
            	arr[i] = sc.nextLine().split(" ");
            }
            
            int time = Integer.MAX_VALUE;
            int idx = 0;
            while(true){
            	if(queue.isEmpty())
                    break;
                Point tmp = queue.poll();
                
                if(tmp.row == 99){
                	if(tmp.time < time){
                    	time = tmp.time;
                        idx = tmp.idx;
                    }else if(tmp.time == time){
                    	if(tmp.idx > idx){
                        	time = tmp.time;
                            idx = tmp.idx;
                        }
                    }
                    continue;
                }
                
                if(tmp.time > time)
                    continue;
                
                if(tmp.dir == 0){
                    boolean flag = true;
                	for(int i=1; i<3; i++){
                    	int nr = Dr[i]+tmp.row;
                        int nc = Dc[i]+tmp.col;
                        if(nc >= 100 || nc < 0)
                            continue;
                        if(arr[nr][nc].equals("1")){
                        	queue.add(new Point(tmp.idx, nr, nc, i, tmp.time+1));
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        queue.add(new Point(tmp.idx, tmp.row+1, tmp.col, 0, tmp.time+1));
                }else{
                	if(arr[tmp.row+1][tmp.col].equals("1"))
                        queue.add(new Point(tmp.idx, tmp.row+1, tmp.col, 0, tmp.time+1));
					else
                        queue.add(new Point(tmp.idx, tmp.row, tmp.col+Dc[tmp.dir], tmp.dir, tmp.time+1));                        
                }
            }
            sb.append(idx+"\n");                  
		}
        System.out.print(sb);
	}
}