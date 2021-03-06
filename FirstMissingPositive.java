/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @author Lu
 *
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,1};
		new FirstMissingPositive().firstMissingPositive(nums);
	}

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i]!= i+1){
                if(nums[i] == nums[nums[i]-1]) break;
                
                //order of swap is important
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }

}
