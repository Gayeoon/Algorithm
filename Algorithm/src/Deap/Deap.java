package Deap;

public class Deap {
	int[] deap;
	int n = 0; //deap에 있는 원소의 개수; 루트는 비어 있다.
	
	public Deap(int maxSize) {
		deap = new int[maxSize]; 
	}
        
        //인덱스 i가 max-heap에 위치해 있으면 true를 리턴하고, 그렇지 않으면 false를 리턴한다
	private boolean inMaxHeap(int i) {
		int[] parent = new int[20];
		int state = 0;
		// 현재 가리키는 인덱스 번호
		int size = 0;
		// 배열의 총 크기
		
		if(i == 1){
			return false;
		// deap[1]은 min heap의 루트이다.
		}
		else if(i == 2){
			return true;
		// deap[2]는 max heap의 루트이다.
		}
		
		else{
			int child1;
			int child2 = 0;
			parent[size] = 2;
			size++;
			
			while(child2 < n){
				child1 = parent[state]*2 + 1;
				child2 = parent[state]*2 + 2;
				
				if(child1 == i || child2 == i){
					return true;
				// 자식 중에 찾는 인덱스가 있으면 true를 리턴한다.
				}
				
				parent[size++] = child1;
				parent[size++] = child2;
				// 배열에 자식들의 인덱스 번호를 넣는다.
				// 자식들의 자식의 인덱스 번호도 찾아야 하기 때문이다.
				state++;				
			}
		}
		return false;
	}

        //인덱스 pos가 min-heap에 위치해 있을때 max partner의 인덱스를 리턴한다
	private int maxPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		int result = (int) (pos + Math.pow(2, exponent));
		
		if(result > n){
			result = (result-1)/2;
		// 파트너가 없을 경우 파트너의 부모와 비교한다.
		}
		
		return result;
	}

        //인덱스 pos가 max-heap에 위치해 있을때 min partner의 인덱스를 리턴한다
	private int minPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		return (int) (pos - Math.pow(2, exponent));
	}
        
        //min-heap에 있는 인덱스 at 위치에 key를 삽입
	private void minInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

        //max-heap에 있는 인덱스 at 위치에 key를 삽입
	private void maxInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key > deap[parent]; deap[at] = deap[parent], at = parent)
			;		
		deap[at] = key;		
	}

        //max 값을 삭제하여 리턴한다
	public int deleteMax() {
		int max = deap[2];
		// max heap의 루트를 max에 따로 저장한다.

		deap[2] = deap[n];
		n--;
		// 맨 마지막 원소를 max heap의 루트 자리로 올린다.
		
		int parent = 2;
		while(parent < n){
		
		int child1 = parent * 2 + 1;
		int child2 = parent * 2 + 2;
		
		if(child1 > n || child2 > n){
			break;
		// 자식의 인덱스 번호가 총 원소의 갯수보다 커지면 종료한다.
		}
		
		int child = (deap[child1]<deap[child2] ? child2:child1);
		// 자식 중 더 큰 것의 인덱스 번호를 저장한다.
		
		if(deap[child] > deap[parent]){
			int temp = deap[child];
			deap[child] = deap[parent];
			deap[parent] = temp;
		// 만약 자식이 부모보다 크다면 두 개의 위치를 바꿔준다.
		}
		
		parent = child;
		// 자식의 인덱스를 부모에게 준다.
		}

		int i = minPartner(parent);
		// min 파트너를 찾는다.
		
		if (deap[parent] < deap[i]) {
			int temp = deap[parent];
			deap[parent] = deap[i];
			minInsert(i, temp);
		} // 파트너가 더 클 경우 서로 바꿔서 minInsert를 한다.
		
		else if (deap[parent] < deap[i*2+1]) {
			int temp = deap[parent];
			deap[parent] = deap[i*2+1];
			minInsert(i*2+1, temp);
		} // 파트너의 자식도 체크한다.
		
		else if (deap[parent] < deap[i*2+2]) {
			int temp = deap[parent];
			deap[parent] = deap[i*2+2];
			minInsert(i*2+2, temp);
		}

		return max;
	}
        
        //min 값을 삭제하여 리턴한다
	public int deleteMin() {
		int min = deap[1];
		// min heap의 루트를 min에 따로 저장한다.

		deap[1] = deap[n];
		n--;
		// 맨 마지막 원소를 min heap의 루트자리로 옮긴다.
		int parent = 1;
		while(parent < n){
		
		int child1 = parent * 2 + 1;
		int child2 = parent * 2 + 2;
		
		if(child1 > n || child2 > n){
			break;
		// 자식의 인덱스 번호가 총 원소의 갯수보다 커지면 종료한다.
		}

		int child = (deap[child1]>deap[child2] ? child2:child1);
		// 자식 중 더 작은 것의 인덱스 번호를 저장한다.
		
		if(deap[child] < deap[parent]){
			int temp = deap[child];
			deap[child] = deap[parent];
			deap[parent] = temp;
		// 만약 자식이 부모보다 작다면 두 개의 위치를 바꿔준다.
		}
		
		parent = child;	
		// 자식의 인덱스 번호를 부모에게 준다.
		
		}

		int i = maxPartner(parent);
		// max 파트너 인덱스를 찾는다.
		
		if (deap[parent] > deap[i]) {
			int temp = deap[parent];
			deap[parent] = deap[i];
			maxInsert(i, temp);
			// 파트너가 더 작을 경우 서로 바꿔서 minInsert를 한다.
		}

		return min;
	}
        
        //x를 삽입한다
	public void insert(int x) {

		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;

		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}
		}
	}

	//deap을 프린트한다
	public void print() {
	        int levelNum = 2;
	        int thisLevel = 0;
	        int gap = 8;
	        for (int i = 1; i <= n; i++) {
	            for (int j = 0; j < gap-1; j++) {
	                System.out.print(" ");
	            }
	            if (thisLevel != 0) {
	                for (int j = 0; j < gap-1; j++) {
	                    System.out.print(" ");
	                }
	            }
	            if (Integer.toString(deap[i]).length() == 1) {
	                System.out.print(" ");
	            }
	            System.out.print(deap[i]);
	            thisLevel++;
	            if (thisLevel == levelNum) {
	                System.out.println();
	                thisLevel = 0;
	                levelNum *= 2;
	                gap/=2;
	            }
	        }
	        System.out.println();
	        if (thisLevel != 0) {
	            System.out.println();
	        }
	}
	
	public static void main(String[] argv) {
		Deap a = new Deap(1024);

		int[] data = { 4, 65, 8, 9, 48, 55, 10, 19, 20, 30, 15, 25, 50 };
		for (int i = 0; i < data.length; i++) {
			a.insert(data[i]);
			//a.print();
		}

		System.out.println("initial Deap");
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();

	}
}
