import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] 
 * @author Lu
 *
 */
public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<List<Integer>> res;
	List<Integer> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	res = new ArrayList();
    	list = new ArrayList();
    	Arrays.sort(candidates);
    	boolean[] used = new boolean[candidates.length];
    	combinationSum(candidates, target, 0, 0, used);
    	return res;
    }
    public void combinationSum(int[] nums, int target, int sum, int index, boolean[] used){
    	if(sum > target) return;
    	if(sum == target){
    		res.add(new ArrayList(list));
    		return;
    	}
    	
    	for(int i = index; i < nums.length; i++){
            if(i>0 && !used[i-1] && nums[i] == nums[i-1]){
                continue;
            }
    		list.add(nums[i]);
    		used[i] = true;
    		combinationSum(nums, target, sum+nums[i], i+1, used);
    		list.remove(list.size()-1);
    		used[i] = false;
    	}
    }


}
