import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * @author Lu
 *
 */
public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		int target = 7;
		System.out.println(new CombinationSum().combinationSum(nums, target));

	}
	
	List<List<Integer>> res;
	List<Integer> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	res = new ArrayList();
    	list = new ArrayList();
    	Arrays.sort(candidates);
    	combinationSum(candidates, target, 0, 0);
    	return res;
    }
    public void combinationSum(int[] nums, int target, int sum, int index){
    	if(sum > target) return;
    	if(sum == target){
    		res.add(new ArrayList(list));
    		return;
    	}
    	
    	for(int i = index; i < nums.length; i++){
    		list.add(nums[i]);
    		combinationSum(nums, target, sum+nums[i], i);
    		list.remove(list.size()-1);
    	}
    }


}
