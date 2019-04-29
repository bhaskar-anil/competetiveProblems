package leetcode;

public class Heaps {
	
	private int maxSize;
	private int x;
	
	static Integer[] buildMaxHeap(Integer[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			
		}
		
		return null;
	}
	
	static Integer getLeftChildIndex(Integer i) {
		return 2*i + 1;
	}
	
	static int getRightChildIndex(Integer i) {
		return 2*i + 2;
	}
	
	static boolean isLeaf(Integer[] arr, Integer i) {
		if(arr[getLeftChildIndex(i)] == null && arr[getRightChildIndex(i)] == null) {
			return true;
		}
		return false;
	}
	
	static void maxHeapify(Integer[] arr, Integer i) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
