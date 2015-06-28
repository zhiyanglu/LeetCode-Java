/**
 * Given an array of n positive integers and a positive
 * integer s, find the minimal length of a subarray of
 * which the sum ≥ s. If there isn't one, return 0 instead.
 * @author Lu
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 1};
		System.out.print(new MinimumSizeSubarraySum().minSubArrayLen(3, a));
	}
	
	
	
	/**
	 * Accepted O(n) solution, two pointers
	 */
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums.length == 0) return 0;
    	
    	int left = 0;
    	int right = 1;
    	
    	int minLen = Integer.MAX_VALUE;
    	int sum = nums[0];
    	while(right < nums.length){
    		while(sum < s && right < nums.length){
    			sum += nums[right];
    			right++;
    		}
    		if(sum >= s)
    			minLen = Math.min(right - left + 1, minLen);
    		while(sum >= s && left < right){
    			sum -= nums[left];
    			left++;
        		minLen = Math.min(right - left + 1, minLen);
    		}
    	}
    	
    	return minLen == Integer.MAX_VALUE ? 0 : minLen;        
    }	
    
    /**
     * O(nlogn) solution
     * compute the sum of previous i numbers and then
     * traverse each number using binary search to 
     * find min length
     */
    public int minSubArrayLen2(int s, int[] nums){
    	if(nums.length == 0) return 0;
    	
    	int[] sums = new int[nums.length];
    	sums[0] = nums[0];
    	for(int i = 1; i < nums.length; i++){
    		sums[i] = sums[i -1] + nums[i];
    	}
    	if(sums[sums.length-1] < s) return 0;
    	
    	int minLen = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length; i++){
    		int l = i;
    		int r = nums.length - 1;
    		while(l <= r){
    			int mid = l + (r - l) / 2;
    			if(sums[mid] - sums[i] + nums[i] == s){
    				l = mid;
    				break;
    			}else if(sums[mid] - sums[i] + nums[i] < s){
    				l = mid+1;
    			}else{
    				r = mid	-1;
    			}
    		}
    		if(l >= sums.length) break;
    		minLen = Math.min(minLen, l - i + 1);
    		
    	}
    	
    	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
