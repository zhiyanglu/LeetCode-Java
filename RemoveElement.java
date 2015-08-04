/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author Lu
 *
 */
public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeElement(int[] nums, int val) {
    	int slow = 0;
    	int fast = 0;
    	while(fast < nums.length){
    		if(nums[fast] != val){
    			nums[slow++] = nums[fast++];
    		}else{
    			fast++;
    		}
    	}
    	return slow;        
    }


}
