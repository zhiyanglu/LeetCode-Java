/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * @author Lu
 *
 */
public class SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        
        //find and set the right most 1 in xor
        xor &= -xor;
        
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if((xor & nums[i]) == 0){
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }
        
        return res;
    }

}
