import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * @author Lu
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * O(nlogn) solution
	 */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int index;
        for(index = nums.length-1; index>0; index--){
            if(nums[index-1]<nums[index]) break;
        }
        if(index == 0){
            Arrays.sort(nums);
            return;
        }
        int next = index;
        for(int i = index; i < nums.length; i++){
            if(nums[index-1]<nums[i] && nums[i] < nums[next])
                next = i;
        }
        int temp = nums[index-1];
        nums[index-1] = nums[next];
        nums[next] = temp;
        Arrays.sort(nums, index, nums.length);
    }

    /**
     * O(n) solution without sort
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int index = nums.length - 1;
        //find first local maximum start from end
        while(index > 0 && nums[index] <= nums[index - 1]){
            index--;
        }
        if(index == 0){
            Arrays.sort(nums);
            return;
        }
        
        int next = index;
        for(int i = index+1; i < nums.length; i++){
            if(nums[i] > nums[index - 1] && nums[i] <= nums[next]) next = i;
        }
        swap(nums, index-1, next);

        int lo = index;
        int hi = nums.length-1;
        while(lo < hi){
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    
}
