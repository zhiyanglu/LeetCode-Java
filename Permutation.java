import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * For example,
	[1,2,3] have the following permutations:	
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author Lu
 *
 */
public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(new Permutation().permute(nums));
	}

	List<List<Integer>> res;
	List<Integer> list;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList();
        list = new ArrayList();
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
    		
    		list.add(nums[i]);
    		used[i] = true;
    		permute(nums, used);
    		list.remove(list.size()-1);
    		used[i] = false;
    	}
    }


}
