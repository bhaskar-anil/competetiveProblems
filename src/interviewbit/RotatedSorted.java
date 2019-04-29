package interviewbit;

import java.util.Arrays;
import java.util.List;

public class RotatedSorted {
	
	public static int search(final List<Integer> a, int b) {
		int p = findPivot(a, 0, a.size()-1);
		if(p == -1) {
			return binarySearch(a, 0, a.size()-1, b);
		} else {
			int i = binarySearch(a, 0, p-1, b);
			int j = binarySearch(a, p, a.size()-1, b);
			if(i != -1) {
				return i;
			} else {
				return j;
			}
		}
    }
	private static int binarySearch(List<Integer> a, int start, int end, int b) {
		if(a.size() == 0) {
			return -1;
		}
		int mid = (start+end)/2;
		
		if(start == end || start+1 == end) {
			if(start == end) {
				if(a.get(start) == b) {
					return start;
				} else {
					return -1;
				}
			}
			if(start+1 == end) {
				if(a.get(start) == b) {
					return start;
				}
				if(a.get(end) == b) {
					return end;
				}
				return -1;
			}
		}
		
		
		if(b < a.get(mid)) {
			return binarySearch(a, start, mid, b);
		} else {
			return binarySearch(a, mid, end, b);
		}
	}
	
	
	static int findPivot(List<Integer> a, int start, int end) {
		
		if (a.get(start) < a.get(end) || a.size() == 1) {
			return -1;
		} else {

			int mid = (start + end) / 2;
			
			if(a.get(mid) > a.get(mid+1)) {
				return mid+1;
			}
			
			if(a.get(mid) < a.get(mid-1)) {
				return mid;
			}

			if (a.get(mid) > a.get(end)) {
				// the pivot is second half
				return findPivot(a, mid, end);
			} else {
				// the pivot is in first half
				return findPivot(a, start, mid);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = {3,4,5,6,7,1,2};
		System.out.println(search(Arrays.asList(a), 7));
	}

}
