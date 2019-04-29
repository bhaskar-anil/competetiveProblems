package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedInsertPosition {
	
	static int searchInsert(List<Integer> a, int b) {
		// binary search
		return binarySearch(a, 0, a.size()-1, b);
    }

	private static int binarySearch(List<Integer> a, int start, int end, int b) {
		if(end == 0) {
			return 0;
		}
		int mid = (start+end)/2;
		
		if(b == a.get(mid)) {
			return mid;
		}
		
		if(start == end || start+1 == end) {
			if(b == a.get(start)) {
				return start;
			}
			if(b == a.get(end)) {
				return end;
			}
			if(b > a.get(start)) {
				if(b < a.get(end)) {
					return start+1;
				} else {
					return end+1;
				}
			}
		}
		
		if(b > a.get(mid)) {
			return binarySearch(a, mid, end, b);
		} else {
			return binarySearch(a, start, mid, b);
		}
	}

	public static void main(String[] args) {
		Integer[] a = {1, 3, 5, 6 };
		System.out.println(searchInsert(Arrays.asList(a), 50));
	}

}
