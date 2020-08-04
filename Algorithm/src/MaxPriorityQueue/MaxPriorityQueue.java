package MaxPriorityQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxPriorityQueue {
	static int size = 1;
	static heapTree heap[] = new heapTree[50];
	static heapTree tree = null;

	public static class heapTree {
		public int key;
		public String name;
		public heapTree left;
		public heapTree right;

		public heapTree(int key, String name) {
			this.key = key;
			this.name = name;
		}

		public heapTree(int key, String name, heapTree left, heapTree right) {
			this.key = key;
			this.name = name;
			this.left = left;
			this.right = right;
		}

		public heapTree(heapTree that) {
			this.key = that.key;
		}

		public int getKey() {
			return key;
		}

		public String getName() {
			return name;
		}

	}

	public static void insert(heapTree[] heap, int x, String s) {
		heap[size] = new heapTree(x, s);

		int temp = size % 2;

		if (size != 1) {
			if (temp == 0) {
				heap[size / 2].left = heap[size];
			} else if (temp == 1) {
				heap[size / 2].right = heap[size];
			}
		}

		int tkey = heap[size].key;
		String tname = heap[size].name;
		
		int num = size;
		
		while(num != 1) {
			if(heap[num/2].key > tkey) {
				break;
			}
			
			else {
				heap[num].key = heap[num/2].key;
				heap[num].name = heap[num/2].name;
				num = num/2;
			}
		}
		heap[num].key = tkey;
		heap[num].name = tname;
		
		size++;
	}

	public static heapTree max(heapTree[] heap) {
		return heap[1];
	}

	public static heapTree extract_max(heapTree[] heap) {
		heapTree max = max(heap);
		size--;
		if (size <= 1) {
			System.out.println("*** 힙이 존재하지 않습니다. ***");
			return max;
		}
		if (heap[size / 2].left != null) {
			heap[size / 2].left = null;
		} else {
			heap[size / 2].right = null;
		}

		heap[1].key = heap[size].key;
		heap[1].name = heap[size].name;

		max_heapify(heap, 1);
		return max;
	}

	public static void max_heapify(heapTree[] heap, int x) {
		int child = 2 * x;
		int temp = heap[x].key;
		String temp_name = heap[x].name;

		while (true) {

			if (heap[x].left == null && heap[x].right == null) {
				break;
			}

			child = 2 * x;

			if (heap[child + 1] != null) {
				if (heap[child].key < heap[child + 1].key) {
					child++;
				}
			}

			if (heap[child].key > temp) {
				heap[x].key = heap[child].key;
				heap[x].name = heap[child].name;
				x = child;
			} else {
				break;
			}
		}

		heap[x].key = temp;
		heap[x].name = temp_name;

	}

	private static void build_max_heap(heapTree[] heap) {
		int x = size / 2;
		while (x != 1) {
			max_heapify(heap, x);
			x--;
		}
		max_heapify(heap, x);
	}

	public static void increase_key(heapTree[] heap, int x, int k) {
		if (k > x) {
			for (int i = 1; i < size; i++) {
				if (heap[i].key == x) {
					heap[i].key = k;
					build_max_heap(heap);
				}
			}
		}
	}

	public static void delete(heapTree[] heap, int x) {
		int check=0;
		for (int i = 1; i < size; i++) {
			if (heap[i].key == x) {
				size--;
				if (heap[size / 2].left != null) {
					heap[size / 2].left = null;
				} else {
					heap[size / 2].right = null;
				}

				heap[i].key = heap[size].key;
				heap[i].name = heap[size].name;

				max_heapify(heap, i);
				check = 1;
			}
		}
		if(check == 0) {
			System.out.println("*** 해당 key가 없습니다. ***");
		}
	}

	public static void print(heapTree[] heap) {
		System.out.println();
		for (int i = 1; i < size; i++) {
			System.out.println(heap[i].key + "," + heap[i].name);
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("1. 작업 추가        2. 최대값         3. 최대 우선순위 작업 처리");
		System.out.println("4. 원소 키값 증가                5. 작업 제거                 6. 종료");
		System.out.println("-----------------------------------------");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("data_heap.txt");

			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, ",");
				int key = Integer.parseInt(parser.nextToken());
				String name = parser.nextToken();
				insert(heap, key, name);

				line = b.readLine();
			}
		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
		}

		Scanner input = new Scanner(System.in);
		int num;
		int check = 0;

		while (check != 1) {
			System.out.println();
			System.out.println("*** 현재 우선 순위 큐에 저장되어 있는 작업 대기 목록 ***");
			print(heap);
			num = input.nextInt();

			switch (num) {
			case 1:
				int newKey;
				String newName;
				System.out.print("신규 작업명 : ");
				newName = input.next();
				System.out.print("우선 순위 : ");
				newKey = input.nextInt();

				insert(heap, newKey, newName);
				break;

			case 2:
				int max_key = max(heap).key;
				String max_name = max(heap).name;
				System.out.println();
				System.out.println("*** MAX : " + max_key + "," + max_name + " ***");
				break;
			case 3:
				extract_max(heap);
				break;
			case 4:
				System.out.print("현재 key : ");
				int rekey = input.nextInt();
				System.out.print("수정할 key : ");
				int newkey = input.nextInt();
				
				if (newkey > rekey) {
					increase_key(heap, rekey, newkey);
				}

				else {
					System.out.println("*** 새로운 key의 값은 기존 key 값보다 커야 합니다. ***");
				}
				break;
			case 5:
				System.out.print("삭제할 key :");
				int dekey = input.nextInt();
				delete(heap, dekey);
				break;
			case 6:
				check = 1;
				break;
			default:
				System.out.println("*** 잘못된 입력입니다. ***");
				print(heap);
			}
		}
	}

}
