package Deap;

public class Deap {
	int[] deap;
	int n = 0; //deap�� �ִ� ������ ����; ��Ʈ�� ��� �ִ�.
	
	public Deap(int maxSize) {
		deap = new int[maxSize]; 
	}
        
        //�ε��� i�� max-heap�� ��ġ�� ������ true�� �����ϰ�, �׷��� ������ false�� �����Ѵ�
	private boolean inMaxHeap(int i) {
		int[] parent = new int[20];
		int state = 0;
		// ���� ����Ű�� �ε��� ��ȣ
		int size = 0;
		// �迭�� �� ũ��
		
		if(i == 1){
			return false;
		// deap[1]�� min heap�� ��Ʈ�̴�.
		}
		else if(i == 2){
			return true;
		// deap[2]�� max heap�� ��Ʈ�̴�.
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
				// �ڽ� �߿� ã�� �ε����� ������ true�� �����Ѵ�.
				}
				
				parent[size++] = child1;
				parent[size++] = child2;
				// �迭�� �ڽĵ��� �ε��� ��ȣ�� �ִ´�.
				// �ڽĵ��� �ڽ��� �ε��� ��ȣ�� ã�ƾ� �ϱ� �����̴�.
				state++;				
			}
		}
		return false;
	}

        //�ε��� pos�� min-heap�� ��ġ�� ������ max partner�� �ε����� �����Ѵ�
	private int maxPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		int result = (int) (pos + Math.pow(2, exponent));
		
		if(result > n){
			result = (result-1)/2;
		// ��Ʈ�ʰ� ���� ��� ��Ʈ���� �θ�� ���Ѵ�.
		}
		
		return result;
	}

        //�ε��� pos�� max-heap�� ��ġ�� ������ min partner�� �ε����� �����Ѵ�
	private int minPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		return (int) (pos - Math.pow(2, exponent));
	}
        
        //min-heap�� �ִ� �ε��� at ��ġ�� key�� ����
	private void minInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

        //max-heap�� �ִ� �ε��� at ��ġ�� key�� ����
	private void maxInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key > deap[parent]; deap[at] = deap[parent], at = parent)
			;		
		deap[at] = key;		
	}

        //max ���� �����Ͽ� �����Ѵ�
	public int deleteMax() {
		int max = deap[2];
		// max heap�� ��Ʈ�� max�� ���� �����Ѵ�.

		deap[2] = deap[n];
		n--;
		// �� ������ ���Ҹ� max heap�� ��Ʈ �ڸ��� �ø���.
		
		int parent = 2;
		while(parent < n){
		
		int child1 = parent * 2 + 1;
		int child2 = parent * 2 + 2;
		
		if(child1 > n || child2 > n){
			break;
		// �ڽ��� �ε��� ��ȣ�� �� ������ �������� Ŀ���� �����Ѵ�.
		}
		
		int child = (deap[child1]<deap[child2] ? child2:child1);
		// �ڽ� �� �� ū ���� �ε��� ��ȣ�� �����Ѵ�.
		
		if(deap[child] > deap[parent]){
			int temp = deap[child];
			deap[child] = deap[parent];
			deap[parent] = temp;
		// ���� �ڽ��� �θ𺸴� ũ�ٸ� �� ���� ��ġ�� �ٲ��ش�.
		}
		
		parent = child;
		// �ڽ��� �ε����� �θ𿡰� �ش�.
		}

		int i = minPartner(parent);
		// min ��Ʈ�ʸ� ã�´�.
		
		if (deap[parent] < deap[i]) {
			int temp = deap[parent];
			deap[parent] = deap[i];
			minInsert(i, temp);
		} // ��Ʈ�ʰ� �� Ŭ ��� ���� �ٲ㼭 minInsert�� �Ѵ�.
		
		else if (deap[parent] < deap[i*2+1]) {
			int temp = deap[parent];
			deap[parent] = deap[i*2+1];
			minInsert(i*2+1, temp);
		} // ��Ʈ���� �ڽĵ� üũ�Ѵ�.
		
		else if (deap[parent] < deap[i*2+2]) {
			int temp = deap[parent];
			deap[parent] = deap[i*2+2];
			minInsert(i*2+2, temp);
		}

		return max;
	}
        
        //min ���� �����Ͽ� �����Ѵ�
	public int deleteMin() {
		int min = deap[1];
		// min heap�� ��Ʈ�� min�� ���� �����Ѵ�.

		deap[1] = deap[n];
		n--;
		// �� ������ ���Ҹ� min heap�� ��Ʈ�ڸ��� �ű��.
		int parent = 1;
		while(parent < n){
		
		int child1 = parent * 2 + 1;
		int child2 = parent * 2 + 2;
		
		if(child1 > n || child2 > n){
			break;
		// �ڽ��� �ε��� ��ȣ�� �� ������ �������� Ŀ���� �����Ѵ�.
		}

		int child = (deap[child1]>deap[child2] ? child2:child1);
		// �ڽ� �� �� ���� ���� �ε��� ��ȣ�� �����Ѵ�.
		
		if(deap[child] < deap[parent]){
			int temp = deap[child];
			deap[child] = deap[parent];
			deap[parent] = temp;
		// ���� �ڽ��� �θ𺸴� �۴ٸ� �� ���� ��ġ�� �ٲ��ش�.
		}
		
		parent = child;	
		// �ڽ��� �ε��� ��ȣ�� �θ𿡰� �ش�.
		
		}

		int i = maxPartner(parent);
		// max ��Ʈ�� �ε����� ã�´�.
		
		if (deap[parent] > deap[i]) {
			int temp = deap[parent];
			deap[parent] = deap[i];
			maxInsert(i, temp);
			// ��Ʈ�ʰ� �� ���� ��� ���� �ٲ㼭 minInsert�� �Ѵ�.
		}

		return min;
	}
        
        //x�� �����Ѵ�
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

	//deap�� ����Ʈ�Ѵ�
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
