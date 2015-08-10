/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author Lu
 *
 */
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,1};
		System.out.println(new SearchInRotatedSortedArray().search(a, 1));
	}
	
	
	/**
	 * Binary Search O(logn) solution
	 * @param nums
	 * @param target
	 * @return
	 */
    public int search(int[] nums, int target) {
        
    	int lo = 0;
    	int hi = nums.length - 1;
    	while(lo < hi){
    		int mid = (lo + hi) / 2;
    		if(nums[mid] == target) return mid;

    		if(nums[lo] > nums[mid]){		//lo is in left half and mid and hi is in right half
    			if(nums[mid] < target && target <= nums[hi])
    				lo = mid+1;
    			else
    				hi = mid-1;
    		}
    		else{
    			if(nums[lo] <= target && target < nums[mid])
    				hi = mid-1;
    			else
    				lo = mid+1;
    		}
    	}
    	
    	return nums[lo] == target ? lo : -1;
    }


}
