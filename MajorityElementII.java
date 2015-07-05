import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array of size n, find all elements that appear
 * more than ⌊ n/3 ⌋ times. The algorithm should run in linear 
 * time and in O(1) space.
 * @author Lu
 *
 */
public class MajorityElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,5,6,3,1,1,1,3,3,2,2,2,3,3,};
		System.out.println(new MajorityElementII().majorityElement(nums));
	}
	
	
	/**
	 * O(n) complexity O(1) space solution based on
	 * Boyer-Moore Majority Vote algorithm: 
	 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
	 */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int a = 0;
		int b = 1;
		int a_count = 0;
		int b_count = 0;
		for(Integer x : nums){
			if(x == a) a_count++;
			else if(x == b) b_count++;
			else{
				if(a_count == 0){
					a = x;
					a_count = 1;
				}else if(b_count == 0){
					b = x;
					b_count = 1;
				}else{
					a_count--;
					b_count--;
				}
			}
		}
		a_count = 0;
		b_count = 0;
		for(Integer x : nums){
			if(x == a) a_count++;
			else if(x == b) b_count++;
		}
		if(a_count > nums.length/3){
			list.add(a);			
		}
		if(b_count > nums.length/3){
			list.add(b);			
		}
		return list;
	}

	/**
	 * O(n) complexity O(n) space solution using hashtable
	 * @param nums
	 * @return
	 */
	public List<Integer> majorityElement2(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) + 1);
			}else{
				map.put(nums[i], 1);
			}
		}
		for(Integer key : map.keySet()){
			if(map.get(key) > nums.length / 3){
				list.add(key);
			}
		}
		return list;
		
    }


}
