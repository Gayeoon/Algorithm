package OceloGame_4615;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int arr[][];
    static int Dr[] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int Dc[] = {0, 0, -1, 1, -1, 1, 1, -1};
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        int answer[][] = new int[T][2];
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n= sc.nextInt();
            int m = sc.nextInt();
            arr = new int[n+1][n+1];
            
            arr[n/2][n/2] = arr[n/2+1][n/2+1] = 2;
            arr[n/2][n/2+1] = arr[n/2+1][n/2] = 1;
            
            for(int i=0; i<m; i++){
            	int row = sc.nextInt();
                int col = sc.nextInt();
                int stone = sc.nextInt();
                arr[row][col] = stone;
                solve(row, col, 0, stone);
            }
            int white = 0;
            int black = 0;
            for(int i=1; i<=n; i++){
            	for(int j=1; j<=n; j++){
                	if(arr[i][j] == 1)
                        black++;
                    else if(arr[i][j] == 2)
                        white++;
                }
            }
            answer[test_case-1][1] = white;
            answer[test_case-1][0] = black;
		}
        for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#"+test_case+" "+answer[test_case-1][0]+" "+answer[test_case-1][1]);
		}

	}
    
    static void solve(int row, int col, int dir, int stone){
    	if(dir == 8)
            return;
        int nr = row + Dr[dir];
        int nc = col + Dc[dir];
        boolean flag = false;
        int[][] temp = new int[arr.length][arr[0].length];
        int cnt = 0;
        while(true){
			if(nr < 1 || nr >= arr.length || nc < 1 || nc >= arr[0].length) break;
            if(arr[nr][nc] == 0)
                break;
            if(arr[nr][nc] == stone) {
                flag = true;
                break;
            }
            temp[nr][nc] = stone;
            
            nr = nr + Dr[dir];
        	nc = nc + Dc[dir];    
        	cnt++;
        }
        if(flag){
        	for(int i=1; i<arr.length; i++){
        		if(cnt == 0) break;
            	for(int j=1; j<arr[0].length; j++){
                    if(temp[i][j] == stone){
	                	arr[i][j] = temp[i][j];
	                	cnt--;
                    }
                }
            }
        }
        solve(row, col, dir+1, stone);
    }
}