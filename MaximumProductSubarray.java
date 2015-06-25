
public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2, 3, 4, -3, -3, 4, 4};
		new MaximumProductSubarray().maxProduct2(a);
	}
	
	
	/*
	 * A solution use swap
	 */
    public int maxProduct(int[] nums) {
    	// store the result that is the max we have found so far
    	int result = nums[0];
    	
    	// imax/imin stores the max/min product of
    	// subarray that ends with the current number A[i]
    	for(int i = 1, max = result, min = result; i < nums.length; i++){

    		// multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
    		if(nums[i] < 0){
    			int temp = max;
    			max = min;
    			min = temp;
    		}
    		
    		// max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
    		max = Math.max(nums[i], max * nums[i]);
    		min = Math.min(nums[i], min * nums[i]);
    		
    		result = Math.max(result, max);
    		
    	}
    	
    	return result;
    }
    
    /*
     * DP solution can use constant space
     */
    public int maxProduct2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] f = new int[A.length];
        int[] g = new int[A.length];
        f[0] = A[0];
        g[0] = A[0];
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
            g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
            res = Math.max(res, f[i]);
        }
        return res;
      }

}
