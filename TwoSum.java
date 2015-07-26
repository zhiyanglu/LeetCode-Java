import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such 
 * that they add up to a specific target number.
 * @author Lu
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]) + 1;
                result[1] = i + 1;
                return result;
            }else{
                map.put(target - nums[i], i);
            }
        }
        
        return result;
    }

}
