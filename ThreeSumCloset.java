import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum 
 * is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * @author Lu
 *
 */
public class ThreeSumCloset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i=0; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi){
                int dif = nums[lo]+nums[hi]+nums[i] - target;
                if(Math.abs(dif) < Math.abs(target-res)) res = nums[lo]+nums[hi]+nums[i];
                if(dif == 0) return target;
                else if(dif < 0) lo++;
                else if(dif > 0) hi--;
            }
        }
        return res;
    }


}
