/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * @author Lu
 *
 */
public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,4};
		int target = 4;
		new SearchForRange().searchRange(nums, target);
	}
	
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1,-1};
        
        int lo = 0;
        int hi = nums.length-1;
        int mid=(lo+hi)/2;
        while(lo <= hi){
            mid = (lo+hi)/2;
            if(nums[mid] == target) break;
            if(nums[mid] < target) lo = mid+1;
            if(nums[mid] > target) hi = mid-1;
        }
        if(nums[mid] != target) return range;
        
        //find left edge
        if(nums[0] == target) range[0] = 0;
        else{
            lo = 0;
            hi = mid;
            while(lo <= hi){
                int left = (lo+hi)/2;
                if(left > 0 && nums[left]==target && nums[left-1]<target){
                    range[0] = left;
                    break;
                }
                if(nums[left]==target) hi=left-1;
                else lo=left+1;
            }
        }
        
        //find right edge
        if(nums[nums.length-1] == target) range[1] = nums.length-1;
        else{
            hi = nums.length-1;
            lo = mid;
            while(lo <= hi){
                int right = (lo+hi)/2;
                if(right < nums.length-1 && nums[right]==target && nums[right+1] > target){
                    range[1] = right;
                    break;
                }
                if(nums[right]==target) lo=right+1;
                else hi=right-1;
            }
            
        }
        
        return range;
    }


}
