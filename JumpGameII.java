/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * @author Lu
 *
 */
public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
		System.out.println(new JumpGameII().jump(nums));
	}
	
    public int jump(int[] nums) {
        int maxReach = nums[0];
        int step = 0;
        int prev = 0;
        
        for(int i = 1; i < nums.length; i++){
        	if(i > prev){
        		prev = maxReach;
        		step++;
        		if(prev >= nums.length -1){
        			return step;
        		}
        	}
        	maxReach = Math.max(maxReach, nums[i]+i);
        	if(maxReach == i) return -1;
        }
        
        return step;
    }


}
