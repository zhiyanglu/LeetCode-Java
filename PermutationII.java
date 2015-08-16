import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * @author Lu
 *
 */
public class PermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2};
		System.out.println(new PermutationII().permuteUnique(nums));
	}
	
	
	List<List<Integer>> res;
	List<Integer> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList();
        list = new ArrayList();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permute(nums, used);
        return res;
    }
    private void permute(int[] nums, boolean[] used){
    	if(list.size() == nums.length){
    		res.add(new ArrayList(list));
    		return;
    	}
    	
    	for(int i = 0; i < nums.length; i++){
    		if(used[i]) continue;
    		if(i>0 && nums[i-1] == nums[i] && !used[i-1]) continue;
    		
    		list.add(nums[i]);
    		used[i] = true;
    		permute(nums, used);
    		used[i] = false;
    		list.remove(list.size()-1);
    	}
    }
    

}
