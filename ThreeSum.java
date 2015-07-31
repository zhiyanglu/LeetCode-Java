import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		System.out.println(new ThreeSum().threeSum(a));
	}
	
	
	/**
	 * O(n^2) solution without hashtable
	 */
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList();
		for(int i = 0; i < nums.length; i++){
			if(i > 0 && nums[i] == nums[i-1]) continue;
			
			int lo = i+1;
			int hi = nums.length-1;
			int sum = 0 - nums[i];
			while(lo < hi){
				if(nums[lo] + nums[hi] == sum){
					res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					while(lo < hi && nums[lo] == nums[lo+1]) lo++;
					while(lo < hi && nums[hi] == nums[hi-1]) hi--;
					lo++;hi--;
				}else if(nums[lo] + nums[hi] < sum) 
					lo++;
				else hi--;
			}
		}
		return res;
	}
	
	/**
	 * O(n^2) solution using hashtable
	 */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            Map<Integer, Integer> map = new HashMap();
            Set<Integer> used = new HashSet<Integer>();
            for(int j = i+1; j < nums.length; j++){
                if(map.containsKey(nums[j]) && !used.contains(nums[j])){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[map.get(nums[j])]);
                    list.add(nums[j]);
                    result.add(list);
                    used.add(nums[j]);
                }else{
                    map.put(0-nums[i]-nums[j], j);
                }
            }
        }
        return result;
    }

	
	
	/**
	 * O(n^3) solution
	 * 
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] nums, int target){		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(nums);
		for(int k = 0; k < nums.length; k++){
			if(k > 0 && nums[k] == nums[k - 1])
				continue;
			
			for(int i = k + 1; i < nums.length; i++){
				if(i > k + 1 && nums[i] == nums[i - 1])
					continue;
				
				HashSet<Integer> set = new HashSet<Integer>();
				int subtarget = target -nums[i] - nums[k];
				for(int j = i + 1; j < nums.length; j++){
					if(j > i + 2 && nums[j] == nums[j - 2]) continue;
					if(set.contains(subtarget - nums[j])){
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(nums[k]);
							list.add(nums[i]);
							list.add(subtarget - nums[j]);
							list.add(nums[j]);
							result.add(list);
					}else{
						set.add(nums[j]);
					}
				}
				
			}

			
		}
		return result;
	
	}
	
	public static ArrayList<Integer> findTwoSum(int[] nums, int start, int target){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = start; i < nums.length; i++){
			if(set.contains(target - nums[i])){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(target - nums[i]);
				list.add(nums[i]);
				return list;
			}else{
				set.add(nums[i]);
			}
		}
		return null;
	}






}
