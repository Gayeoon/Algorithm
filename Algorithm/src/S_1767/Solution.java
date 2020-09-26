package S_1767;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
	int row, col;
    Point(int row, int col){
    	this.row = row;
        this.col = col;
    }
}

class Solution
{
    static int arr[][];
    static ArrayList<Point> list;
    static int Dr[] = {-1,1,0,0};
    static int Dc[] = {0,0,-1,1};
    static int now_cnt=0, result = 0;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            now_cnt=0;
            result = 0;
            int n = sc.nextInt();
            arr = new int[n][n];
            list = new ArrayList<>();
            
            for(int i=0; i<n; i++){
            	for(int j=0; j<n; j++){
                	arr[i][j] = sc.nextInt();
                	if(arr[i][j] == 1){
                    	if(i == 0 || j == 0 || i == n-1 || j == n-1){
                            continue;
                        }
                        list.add(new Point(i,j));
                    }
                }
            }
            backtracking(0, 0, 0);
			sb.append("#"+test_case+" "+result+"\n");
		}
		System.out.println(sb);
	}
    
    static void backtracking(int idx, int cnt, int line){
        if(idx >= list.size()){
        	if(now_cnt < cnt){
                now_cnt = cnt;
            	result = line;
            }else if(now_cnt == cnt){
                result = Math.min(result, line);
            }
            return;
        }
        Point now = list.get(idx);
    	for(int i=0; i<4; i++){
            int tmp = check(now.row, now.col, i, true);
        	if(tmp > 0){
                backtracking(idx+1, cnt+1, line+tmp);
            	check(now.row, now.col, i, false);
            }
        }
        backtracking(idx+1, cnt, line);
    }
    
    static int check(int row, int col, int dir, boolean flag){
    	if(flag){
            int nr = row, nc = col;
            boolean check = true;
            int cnt = 0;
        	while(true){
            	nr += Dr[dir];
                nc += Dc[dir];
                if(nr<0 || nr>= arr.length || nc<0 || nc >= arr.length)
                    break;
                if(arr[nr][nc] == 1){
                	check = false;
                    break;
                }
                arr[nr][nc] = 1;
                cnt++;
            }
            if(check)
                return cnt;
            else{
            	while(true){
            		nr -= Dr[dir];
                	nc -= Dc[dir];
                	if(nr == row && nc == col)
	                    break;
                	arr[nr][nc] = 0;
	            }
                return -1;
            }
        }else{
            int nr = row, nc = col;
        	while(true){
            	nr += Dr[dir];
                nc += Dc[dir];
                if(nr<0 || nr>= arr.length || nc<0 || nc >= arr.length)
                    break;
                arr[nr][nc] = 0;
            }
        	return -1;
        }
    }
}