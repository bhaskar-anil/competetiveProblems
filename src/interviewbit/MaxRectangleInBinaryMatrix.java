package interviewbit;

import java.util.ArrayList;

public class MaxRectangleInBinaryMatrix {
	
	public static int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();//height
        int n = A.get(0).size();//width
        
        int min = (m <= n) ? m : n; //get the min 
        
        
        
        
        return 0;
    }

	private static int area(int l, int r, int t, int b) {
		return 0;
	}
	
	private static boolean isValidRectangle(ArrayList<ArrayList<Integer>> A, int l, int r, int t, int b) {
		if(A.get(t).get(l) == 1 && A.get(b).get(l) == 1
				&&
		   A.get(t).get(r) == 1 && A.get(b).get(r) == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
