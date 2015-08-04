/**
 * Given a sorted array, remove the duplicates in place such that each 
 * element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in 
 * place with constant memory.
 * @author Lu
 *
 */
public class RmoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public int removeDuplicates(int[] nums) {
    	if(nums.length == 0 || nums.length == 1) return nums.length;
    	int slow = 0;
    	int fast = 1;
    	int len = nums.length;
    	while(fast < len){
    		while(fast < len && nums[fast] == nums[slow])
    			fast++;
    		if(fast < len)
    			nums[++slow] = nums[fast];
    	}
    	
    	return slow+1;
    }


}
