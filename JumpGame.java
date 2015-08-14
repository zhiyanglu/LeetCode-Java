/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * @author Lu
 *
 */
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        for(int i = 0;i < nums.length; i++){
            if(i > maxReach) return false;
            if(maxReach >= nums.length - 1) return true;
            maxReach = Math.max(maxReach, nums[i]+i);
        }
        return maxReach >= nums.length-1;
    }


}
