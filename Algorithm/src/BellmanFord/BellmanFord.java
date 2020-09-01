package BellmanFord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class BellmanFord {
	static int node = 0;
	static int inf = (int) Double.POSITIVE_INFINITY;
	static int edge_num = 0;
	static boolean check = true;

	public static int[] bellmanFord(Edge edge[], int s) {
		int visit[] = new int[node];
		visit[s] = 0;
		int count = 1;

		for (int i = 0; i < node; i++) {
			visit[i] = inf;
		}
		visit[s] = 0;

		for(int i=0; i<edge_num; i++) {
			if(edge[i].getStart() == s) {
				visit[edge[i].getFinish()] = edge[i].getValue();
			}
		}
		
		while (count < node) {

			for (int i = 0; i < edge_num; i++) {
				if (edge[i].getValue() != inf) {
					if (visit[edge[i].getStart()] != inf
							&& visit[edge[i].getFinish()] > edge[i].getValue() + visit[edge[i].getStart()]) {
						visit[edge[i].getFinish()] = edge[i].getValue() + visit[edge[i].getStart()];
					}
				}
			}

			count++;
		}

		
		for (int i = 0; i < edge_num; i++) {
			if (edge[i].getValue() != inf) {
				if (visit[edge[i].getStart()] != inf
						&& visit[edge[i].getFinish()] > edge[i].getValue() + visit[edge[i].getStart()]) {
					
					check = false;
				}
			}
		}

		return visit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s = 0;
		int t = 0;
		int count = 0;
		Edge edge[] = null;

		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("input.txt");

			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			StringTokenizer parser1 = new StringTokenizer(line, "");
			node = Integer.parseInt(parser1.nextToken());
			line = b.readLine();

			StringTokenizer parser2 = new StringTokenizer(line, " ");
			s = Integer.parseInt(parser2.nextToken());
			t = Integer.parseInt(parser2.nextToken());
			line = b.readLine();

			StringTokenizer parser3 = new StringTokenizer(line, "");
			edge_num = Integer.parseInt(parser3.nextToken());
			line = b.readLine();

			edge = new Edge[edge_num];

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");
				while (parser.hasMoreTokens()) {
					int node1 = Integer.parseInt(parser.nextToken());
					int node2 = Integer.parseInt(parser.nextToken());
					int value = Integer.parseInt(parser.nextToken());

					Edge temp = new Edge(node1, node2, value);

					edge[count] = temp;
					count++;
				}
				line = b.readLine();
			}

		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
		}

		int result[] = new int[node];

		result = bellmanFord(edge, s);

		if(check) {
		System.out.println(result[t]);
		}
		else {
			System.out.println("그래프에 Negative-weight cycle이 생깁니다.");
		}
	}

}

class Edge {
	private int start;
	private int finish;
	private int value;

	public Edge(int start, int finish, int value) {
		this.setStart(start);
		this.setFinish(finish);
		this.setValue(value);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
