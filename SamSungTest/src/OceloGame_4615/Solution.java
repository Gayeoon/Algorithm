package OceloGame_4615;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution
{
    static int arr[][];
    static int Dr[] = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int Dc[] = {0, 0, -1, 1, -1, 1, 1, -1};
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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