package interviewbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	
	public int majorityElement(final List<Integer> A) {
        Map<Integer, Integer> me = new HashMap<>();
        double majorityNumber = Math.floor(A.size()/2);
        for(int i = 0; i < A.size(); i++) {
           if(me.get(A.get(i)) != null){
               me.put(A.get(i), me.get(A.get(i))+1);
           } else {
               me.put(A.get(i), 1);
           }
           if(me.get(A.get(i)) > majorityNumber){
               return A.get(i);
           }
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
