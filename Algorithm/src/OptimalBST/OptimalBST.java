package OptimalBST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OptimalBST {
	static double e[][];
	static double w[][];
	static int root[][];
	
	public static void bst(double[] p, double[] q, int n) {
		e = new double[n+1][n+1];
		w = new double[n+1][n+1];
		root = new int[n+1][n+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j =0; j<n+1; j++){
				root[i][j] = -1;
				e[i][j] = -1;
				w[i][j] = -1;
				
			}
		}
		
		for (int i = 1; i < n + 1; i++) {
			e[i][i - 1] = q[i - 1];
			w[i][i - 1] = q[i - 1];
		}
		
	
		
		for(int l =1; l <n; l++) {
			for(int i =1; i<n-l+1; i++) {
				int j = i+l-1;
				e[i][j] = Double.POSITIVE_INFINITY;
				w[i][j] = w[i][j-1]+p[j]+q[j];
				for(int r = i; r<=j; r++) {
					double t = e[i][r-1]+e[r+1][j]+w[i][j];
					if(t<e[i][j]) {
						e[i][j] = t;
						root[i][j] = r;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] p = new double[10];
		double[] q = new double[10];
		int count = 0;

		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("data11.txt");

			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, "\t");
				while (parser.hasMoreTokens()) {

					p[count] = Double.parseDouble(parser.nextToken());
					q[count] = Double.parseDouble(parser.nextToken());

					count++;
				}
				line = b.readLine();
			}

		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
		}

		System.out.println("-------------------------------------------------------------------");
		System.out.println("\tp\tq");
		for (int i = 0; i < count; i++) {
			System.out.println(i+"\t"+p[i] + "\t" + q[i]);
		}

		System.out.println("\nThe number of keys : "+ (count-1));

		
		bst(p, q, count);

		System.out.println("-------------------------------------------------------------------");
		System.out.println("e(i,j)");
		System.out.println("\t0\t1\t2\t3\t4\t5\t6");
		for(int i=0; i<count+1; i++) {
			System.out.print(i+"\t");
			for(int j =0; j<count+1; j++){
				System.out.print(String.format("%.2f\t", (Object)e[i][j]));
			}
			System.out.println();
		}

		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("w(i,j)");
		System.out.println("\t0\t1\t2\t3\t4\t5\t6");
		for(int i=0; i<count+1; i++) {
			System.out.print(i+"\t");
			for(int j =0; j<count+1; j++){
				System.out.print(String.format("%.2f\t", (Object)w[i][j]));
			}
			System.out.println();
		}

		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("root(i,j)");
		System.out.println("\t0\t1\t2\t3\t4\t5\t6");
		for(int i=0; i<count+1; i++) {
			System.out.print(i+"\t");
			for(int j =0; j<count+1; j++){
				System.out.print(root[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------");

		System.out.println("Minimum expected search cost : "+e[1][count-1]);
	}

}
