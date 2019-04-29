package leetcode;

public class SortingAlgos {
	
	public static int[] insertionSort(int[] arr) {
		
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
		return arr;
	}

	public static void main(String[] args) {
		insertionSort(new int[]{4, 3, 1, 8, -1, 0, 7});
	}

}
