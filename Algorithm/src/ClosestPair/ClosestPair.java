package ClosestPair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import MaxPriorityQueue.MaxPriorityQueue.heapTree;

public class ClosestPair {
	static int size = 0;
	static coordinate[] coordinate = new coordinate[10000];

	/* 좌표를 저장할 노드를 만든다. */
	public static class coordinate {
		public double x;
		public double y;
		
		public coordinate(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getx() {
			return x;
		}

		public double gety() {
			return y;
		}

	}
	
	/* 점들의 x좌표를 오름차순으로 정렬 */
	public static int partition(coordinate[] array, int p, int r) {
		double x = array[r].x;
		int i = p-1;
		
		for(int j = p; j < r; j++) {
			if(array[j].x <= x) {
				i++;
				sort(array, i, j);
			}
		}
		
		i++;
		sort(array, i, r);
		
		return i;
	}
	
	public static void quickSort(coordinate[] array, int p, int r) {
		if(p<r) {
			int q = partition(array, p, r);
			quickSort(array, p, q-1);
			quickSort(array, q+1, r);
		}
		else
			return;
	}

	public static void sort(coordinate[] array, int i, int j) {
		double temp_x = array[i].x;
		double temp_y = array[i].y;
		
		array[i].x = array[j].x;
		array[i].y = array[j].y;
		
		array[j].x = temp_x;
		array[j].y = temp_y;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] x = new double[10000];
		double[] y = new double[10000];
		int count = 0;
		
		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("input.txt");
			
			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " \n");
				while (parser.hasMoreTokens()) {
					x[count] = Double.parseDouble(parser.nextToken());
					y[count] = Double.parseDouble(parser.nextToken());
					count++;
					// 데이터를 array 배열에 하나씩 저장한다.
				}
				line = b.readLine();
			}
		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
		}
		
		for(int i=0; i<count; i++) {
			coordinate[i] = new coordinate(x[i], y[i]);
		}

		System.out.println("Input Data : \t( "+coordinate[1].x+" "+coordinate[0].y+" )");
		for(int i=1; i<count; i++) {
			System.out.println("\t\t( "+coordinate[i].x+" "+coordinate[i].y+" )");
		}

		quickSort(coordinate, 0, count-1);
		
		double[] result = new double[5];
		
		result = closestPair(coordinate, 0, count-1);
		
		System.out.print("Output Data : ");
		System.out.println("( "+result[0]+", "+result[1]+" ) ( "+result[2]+", "+result[3]+" )");
		System.out.println("\t      "+result[4]);
		
	}
	
	public static double[] closestPair(coordinate[] coor, int p, int q) {
		if(q-p >= 3) {
			double[] d1 = new double[5];
			double[] d2 = new double[5];
			double[] min_d = new double[5];
			
			d1 = closestPair(coor, p, (p+q)/2);
			d2 = closestPair(coor, (p+q)/2, q);
			min_d = min(d1, d2);
			
			double[] bet_d = new double[5];
			bet_d[4] = 10000;
			
			double min = (p+q)/2;
		
			int[] temp = new int[10000];
			int size = 0;

			
			for(int i=p; i<=q; i++) {
				if(min - min_d[4] <= coor[i].x && coor[i].x <= min + min_d[4]) {
					temp[size] = i;
					size++;
				}
			}
			
			for(int i=0; i<size; i++) {
				for(int j =i+1; j<size; j++) {
					if(-min_d[4] <= coor[temp[i]].y - coor[temp[j]].y && coor[temp[i]].y - coor[temp[j]].y <= min_d[4]) {
						double[] temp_dist = new double[5];
						temp_dist = closestPair_dist(coor, temp[i], temp[j]);
						bet_d = min(temp_dist, bet_d);
					}
				}
			}
			
			min_d = min(min_d, bet_d);
			
			return min_d;
		}else if(q-p == 2) {
			double[] dist1 = new double[5];
			double[] dist2 = new double[5];
			double[] dist3 = new double[5];
			
			dist1 = closestPair_dist(coor, p, p+1);
			dist2 = closestPair_dist(coor, p+1, q);
			dist3 = closestPair_dist(coor, p, q);

			double[] min_dist1 = new double[5];
			double[] min_dist2 = new double[5];
			
			min_dist1 = min(dist1, dist2);
			min_dist2 = min(min_dist1, dist3);
			
			return min_dist2;
		}else {
			return closestPair_dist(coor, p, q);
		}
	}

	/* 거리 구하는 함수 */
	private static double[] closestPair_dist(coordinate[] coor, int p, int q) {

		double x = Math.pow((coordinate[p].x - coordinate[q].x), 2);
		double y = Math.pow((coordinate[p].y - coordinate[q].y), 2);

		double result = x + y;
		result = Math.sqrt(result);
		
		double temp[] = new double[5];
		
		temp[0] = coor[p].x;
		temp[1] = coor[p].y;
		temp[2] = coor[q].x;
		temp[3] = coor[q].y;
		temp[4] = result;
		
		return temp;
	}

	private static double[] min(double[] d1, double[] d2) {

		if(d1[4] > d2[4]) {
			return d2;
		}
		else {
			return d1;
		}
	}

}
