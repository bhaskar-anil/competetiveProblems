package interviewbit;



public class PaintersPartitionProblem {
	
	int partition(int[] arr, int n, int k){
		if(k == 1) {
			return sum(arr, 0, n);
		}
		if(n == 1) {
			return arr[0];
		}
		
		for(int i = 1; i < n; i++) {
			partition(arr, i, k - 1);
		}
		
		return -1; // this is wrong
		
	}
	
	int sum(int arr[], int from, int to) {
		int sum = 0;
		for(int i = from; i < to; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
