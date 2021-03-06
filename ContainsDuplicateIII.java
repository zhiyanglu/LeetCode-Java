import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether 
 * there are two distinct indices i and j in the 
 * array such that the difference between nums[i] 
 * and nums[j] is at most t and the difference 
 * between i and j is at most k.
 * @author Lu
 *
 */
public class ContainsDuplicateIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-5 / 4);
	}
	
	/**
	 * O(nlogk) complexity O(k) space solution using TreeSet
	 */
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
		if(k < 1 || t < 0) return false;
		TreeSet<Long> tree = new TreeSet<Long>();
		
		for(int i = 0; i < nums.length; i++){
			long min = (long)nums[i] - t;
			long max = (long)nums[i] + t;
			Long floor = tree.floor(max);
			Long ceil = tree.ceiling(min);
			if((floor != null && floor >= min) || 
					(ceil != null && ceil <= max))
				return true;
			tree.add((long)nums[i]);
			if(i >= k){
				tree.remove((long) nums[i - k]);
			}
		}
		return false;
	}

	/**
	 * O(n) complexity O(k) space solution using bucket
	 * Create a bucket size of t+1 to store one number
	 * Return true if:
	 * 	1.two numbers in a same bucket
	 * 	2.two numbers in two nearyby bucket and their difference are at most t
	 * 
	 */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap();
        
        for(int i = 0; i < nums.length; i++){
        	long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
        	long bucket = remappedNum / ((long) t + 1);
        	if(map.containsKey(bucket)	//two numbers in same bucket or check nearby buckets
        			|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
        			|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
        		return true;
        	if(map.entrySet().size() >= k){
        		long lastBucket = ((long) nums[i-k] - Integer.MIN_VALUE) / ((long) t + 1);
        		map.remove(lastBucket);
        	}
        	map.put(bucket, remappedNum);
        }
        return false;
        
    }

}
