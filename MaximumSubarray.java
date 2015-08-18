/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author Lu
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new MaximumSubarray().maxSubArray(nums));
	}
	
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = 0;
        
        for(Integer num : nums){
        	current += num;
        	max = Math.max(current, max);
        	if(current < 0) current = 0;
        }
        return max;
    }


}
