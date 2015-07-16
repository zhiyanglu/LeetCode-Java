/**
 * Given an array of n integers where n > 1, nums, return an 
 * array output such that output[i] is equal to the product 
 * of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * @author Lu
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		new ProductOfArrayExceptSelf().productExceptSelf(nums);
	}
	
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++){
        	output[i] = output[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
        	output[i] = output[i] * right;
        	right = right * nums[i];
        }
        return output;
    }


}
