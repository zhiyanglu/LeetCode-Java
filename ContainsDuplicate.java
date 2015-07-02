import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array 
 * contains any duplicates. Your function should 
 * return true if any value appears at least twice 
 * in the array, and it should return false if 
 * every element is distinct.
 * @author Lu
 *
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	/**
	 * HashTable solution. O(n) complexity and O(n) space
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums){
		Set<Integer> set = new HashSet<Integer>();
		for(int num : nums){
			if(!set.add(num)) return true;
		}
		return false;
	}
	
	/**
	 * O(nlogn) complexity O(1) space sorting solution
	 */
	public boolean containsDuplicate2(int[] nums){
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i - 1]) return true;
		}
		return false;
	}
	
	/**
	 * O(n^2) complexity O(1) space brute force solution
	 */
	public boolean containsDuplicate3(int[] nums){
		int len = nums.length;
		for(int i = 0; i < len; i++){
			for(int j = i + 1; j < len; j++){
				if(nums[i] == nums[j]) return true;
			}
		}
		return false;
	}

}
