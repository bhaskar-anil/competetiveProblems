package interviewbit;

public class LongestPrefix {
	
    static String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder("");
        //if any of the string is empty return empty string
        for(int j = 0; j < strs.length; j++) {
           if(strs[j].length() == 0){
              return str.toString(); 
           } 
        }
        
        for(int i = 0; strs.length != 0 && i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
               if(strs[j-1].charAt(i) != strs[j].charAt(i)) {
                   return str.toString();
               }
            }
            str.append(strs[0].charAt(i));
        }
       return str.toString(); 
    }

	public static void main(String[] args) {
		String[] strs = {};
		System.out.println(longestCommonPrefix(strs));

	}

}
