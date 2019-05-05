package leetcode;

public class SortingAlgos {
	int size;
	int [] arr;
	
	
	
	public void insertionSort() {
		
		for(int i = 1; i < arr.length; i++) {
			int insertion = i;
			int j =insertion-1;
			while(j >= 0 && arr[insertion] < arr[insertion-1]) {
				//swap code
				int temp = arr[insertion];
				arr[insertion] = arr[insertion-1];
				arr[insertion-1] = temp;
				
				j--;
				insertion--;
			}
		}
	}
	
	public void mergeSort(int l, int r) {
		if(r > 1) {
			int mid = (l + r)/2;
			// left half
			mergeSort(l, mid);
			
			// right half
			mergeSort(mid+1, r);
			
			merge(l, mid, r);
		}
	}
	
	

	private void merge(int l, int mid, int r) {
		
	}

	public static void main(String[] args) {
		SortingAlgos s = new SortingAlgos();
		s.arr = new int[]{1,3,4,2,7};
		
		//s.insertionSort();
		s.mergeSort(0, 4);
	}

}
