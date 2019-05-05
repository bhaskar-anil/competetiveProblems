package interviewbit;

public class Merge2SortedArrays {
	
	static int[] merge(int[] arr1, int[] arr2) {
		
		int i = 0, j = 0, k = 0;
		
		int[] sorted = new int[arr1.length + arr2.length];
		
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				sorted[k] = arr1[i];
				i++;
				k++;
			} else {
				sorted[k] = arr2[j];
				j++;
				k++;
			}
		}
		if(i == arr1.length) {
			for(i = j; i < arr2.length; i++) {
				sorted[k] = arr2[i];
				k++;
			}
		} else {
			for(j = i; j < arr1.length; j++) {
				sorted[k] = arr1[j];
				k++;
			}
		}
		
		return sorted;
	}
	

	public static void main(String[] args) {
		merge(new int[]{1,2,3,4,5}, new int[]{});
	}

}
