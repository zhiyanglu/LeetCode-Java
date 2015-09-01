/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * @author Lu
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] < nums.length && nums[i] != i){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        
        return i;
    }


}
