import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out
 * whether there there are two distinct indices i and j 
 * in the array such that nums[i] = nums[j] and the 
 * difference between i and j is at most k.
 * @author Lu
 *
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * O(n) complexity O(n) space solution using Set only
	 * Keep only continuous k elements in the set
	 */
	public boolean containsNearbyDuplicate2(int[] nums, int k){
		if(k == 0) return false;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(!set.add(nums[i])) return true;
			//remain only k elements in the set
			if(i + 1 > k){
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
	
	/**
	 * O(n) complexity O(n) space solution using HashMap;
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k){
		if(k == 0) return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i]) && map.get(nums[i]) + k >= i)
				return true;
			else 
				map.put(nums[i], i);
		}
		return false;
	}

}
