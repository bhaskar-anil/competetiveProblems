package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
	
	public static ArrayList<Integer> spiralOrder(List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int direction = 0;
        
        int top = 0, right = A.get(0).size(), bottom = A.size(), left = 0;
        
        
        while(top < bottom && left < right) {
            //there will be four cases
            //left -> right
            if(direction == 0) {
                for(int i = left; i < right; i++) {
                    result.add(A.get(top).get(i));
                    direction = 1; 
                }
                top++;
                
            }
            
            //top -> bottom
            if(direction == 1) {
                for(int i = top; i < bottom; i++) {
                    result.add(A.get(i).get(right-1));
                    direction = 2;
                }
                right--;
                
            }
            
            //right -> left
            if(direction == 2) {
                for(int i = right-1; i >= left; i--) {
                    result.add(A.get(bottom-1).get(i));
                    direction = 3;
                }
                bottom--;
                
            }
            
            //bottom -> top
            if(direction == 3){
                for(int i = bottom-1; i >= top; i--){
                    result.add(A.get(i).get(left));
                    direction = 0;
                }
                left++;
                
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList( 1, 	2, 	3, 	4, 	5  ));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList( 10,	20,	30,	40,	50 ));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList( 11,	12,	13,	14,	15 ));
		ArrayList<Integer> row4 = new ArrayList<Integer>(Arrays.asList( 21,	32,	43,	54,	65 ));

		List<ArrayList<Integer>> A = new ArrayList<>(); A.add(row1);A.add(row2);A.add(row3);A.add(row4);
		spiralOrder(A);
	}

}
