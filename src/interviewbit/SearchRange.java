package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
	static public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		
		int f = binarySearch(a, 0, a.size()-1, b);
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(f != -1) {
			//lower bound
			int i = f;
			int j = f;
			while(i > 0 && a.get(i-1) == b) {
				i--;
			}
			while(j < a.size()-1 && a.get(j+1) == b) {
				j++;
			}
			result.add(i);
			result.add(j);
		} else {
			result.add(-1);
			result.add(-1);
		}
		
		return result;
	}

	private static int binarySearch(List<Integer> a, int start, int end, int b) {
		if(a.size() == 0 || start > end) {
			return -1;
		}
		
		if(start == end || start+1 == end) {
			if(a.get(start) == b) {
				return start;
			} else if(a.get(end) == b) {
				return end;
			} else {
				return -1;
			}
		}
		
		int mid = (start+end)/2;
		
		if(a.get(mid) == b) {
			return mid;
		}
		
		if(a.get(mid) > b) {
			return binarySearch(a, start, mid, b);
		} else {
			return binarySearch(a, mid, end, b);
		}
	}

	public static void main(String[] args) {
		Integer[] a = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 
};
		searchRange(Arrays.asList(a), 4);
	}

}
