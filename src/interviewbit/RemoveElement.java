package interviewbit;

public class RemoveElement {
	
	
static int removeElement(int[] nums, int val) {
    
    
    for(int b = nums.length-1, f = 0; b >= f; ) {
      while(b >= 0 && nums[b] == val){b--;}  
      while(f < nums.length && nums[f] != val){f++;} 
      
      if(b > f && nums[b] != val && nums[f] == val) {
    	  int temp = nums[b];
    	  nums[b] = nums[f];
          nums[f] = temp;
      }
      
    }
    int i = 0;
    for(i = 0; i < nums.length; i++){
        if(nums[i] == val){
           break; 
        }
    }
    return i;
}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,4,2,3,2,3,2,1,2};
		
		removeElement(nums, 2);
		System.out.println(nums);
	}

}
