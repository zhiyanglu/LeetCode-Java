import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,0,0,0,0,0,0,0,0};
		System.out.println(threeSum(a, 0));
	}
	
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
