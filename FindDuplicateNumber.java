import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 * @author Lu
 *
 */
public class FindDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	/**
	 * O(nlogn) solution based on sort
	 * @param nums
	 * @return
	 */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) return nums[i];
        }
        
        return -1;
    }
    
    /**
     * O(n) solution based on moving number to corresponding position
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i && nums[i] != nums[nums[i]]){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        
        return nums[0];
    }



}
