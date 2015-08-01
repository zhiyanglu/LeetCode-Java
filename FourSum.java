import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? Find all unique quadruplets in the 
 * array which gives the sum of target.
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * @author Lu
 *
 */
public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for(int i=0; i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int b = nums[j];
                int lo = j+1;
                int hi = nums.length-1;
                while(lo < hi){
                    int sum = a + b + nums[lo] + nums[hi];
                    if(sum == target){
                        res.add(Arrays.asList(a,b,nums[lo],nums[hi]));
                        while(lo < hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo < hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;hi--;
                    }else if(sum < target) lo++;
                    else if(sum > target) hi--;
                }
            }
        }
        return res;
    }


}
