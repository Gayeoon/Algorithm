package S_1229;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;

public class Solutiono {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();
		for(int test_case = 1; test_case <= 1; test_case++)
		{
			sb.append("#"+test_case);
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            
            for(int i=0; i<n; i++)
                list.add(sc.nextInt());
            
            int q = sc.nextInt();
            
            for(int i=0; i<q; i++){
            	String str = sc.next();
                int idx = sc.nextInt();
                if(str.equals("I")){
                    int y = sc.nextInt();
                    for(int j=0; j<y; j++){
                		list.add(idx, sc.nextInt());
                    	idx++;
                    }
                }else{
                    int y = sc.nextInt();
                    for(int j=0; j<y; j++)
                        list.remove(idx);
                }
            }
            
            for(int i=0; i<10; i++)
                sb.append(" "+list.get(i));
            sb.append("\n");
        }
        System.out.print(sb);
	}
}
