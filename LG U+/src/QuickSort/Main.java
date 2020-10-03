package QuickSort;

class Quick {
    public void sort(int[] arr, int l, int r){
       int right = r;
       int left = l;
       int pivot = arr[(r+l)/2];
       
       do {
    	   while(arr[right] > pivot) right--;
    	   while(arr[left] < pivot) left++;
    	   if(left <= right) {
    		   int tmp = arr[right];
    		   arr[right] = arr[left];
    		   arr[left] = tmp;
    		   left++;
    		   right--;
    	   }
       }while(left <= right);
       
       if(l < right) sort(arr, l, right);
       if(r > left) sort(arr, left, r);
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[10];
		
		for(int i=0; i<10; i++)
			arr[i] = (int) (Math.random() * 10);
		
		Quick quick = new Quick();
		quick.sort(arr, 0, 9);
		
		for(int i=0; i<10; i++)
			System.out.print(arr[i]+" ");
	}
}
