package S_1230;
import java.util.Scanner;
import java.util.LinkedList;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			LinkedList<Integer> list = new LinkedList<>();
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
            	list.add(sc.nextInt());
            }
			int m = sc.nextInt();
            
            for(int i=0; i<m; i++){
            	char tmp = sc.next().charAt(0);
                int idx, y;
                switch(tmp){
                    case 'I':
                        idx = sc.nextInt();
                        y = sc.nextInt();
                        for(int k=0; k<y; k++){
                        	list.add(idx, sc.nextInt());
                            idx++;
                        }
                        break;
                    case 'D':
                        idx = sc.nextInt();
                        y = sc.nextInt();
                        for(int k=0; k<y; k++){
                        	list.remove(idx);
                        }
                        break;
                    case 'A':
                        y = sc.nextInt();
                        for(int k=0; k<y; k++){
                        	list.add(sc.nextInt());
                        }
                        break;
                    default:
                        break;
                }
            }
            sb.append("#"+test_case);
            for(int i=0; i<10; i++)
                sb.append(" "+list.get(i));
            sb.append("\n");
		}
        System.out.print(sb);
	}
}