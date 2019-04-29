package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
	
	

	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println(generateParenthesis(3));
		/*
		 * 			  5
		 * 		2			7
		 * 	1		4	6		8
		 * 		3
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		

		
		

	}
	
	
	
	public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            System.out.println("ans.add("+cur+");");
            System.out.println("return;\n");
            return;
        }

        if (open < max){
        		System.out.println("backtrack("+ans+", "+cur+"(, "+open+"+1, "+close+", "+max+");");
            backtrack(ans, cur+"(", open+1, close, max);
            }
        if (close < open) {
        		System.out.println("backtrack("+ans+", "+cur+"), "+open+", "+close+"+1, "+max+");");
        		backtrack(ans, cur+")", open, close+1, max);
        }
            
    }


}

































