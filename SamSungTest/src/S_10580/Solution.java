package S_10580;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Line implements Comparable<Line>{
	int a, b;
    Line(int a, int b){
    	this.a = a;
        this.b = b;
    }
    
    @Override
    public int compareTo(Line l){
    	return this.a - l.a;
    }
}

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            Line line[] = new Line[n];
            
            for(int i=0; i<n; i++){
            	line[i] = new Line(sc.nextInt(), sc.nextInt());
            }
            
            Arrays.sort(line, null);
            
            int cnt = 0;
            for(int i=0; i<n; i++){
            	for(int j=i+1; j<n; j++){
                	if(line[i].b > line[j].b) cnt++;
                }
            }
            
            sb.append("#"+test_case+" "+cnt+"\n");
		}
        System.out.print(sb);
	}
}