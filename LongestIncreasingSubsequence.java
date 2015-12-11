
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
		solution.lengthOfLIS(nums);
	}
	
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] last = new int[nums.length + 1];
        last[1] = nums[0];
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > last[max]){
                max++;
                last[max] = nums[i];
            }else{
                //find the frist number in last[] that is larger than nums[i];
                int lo = 1;
                int hi = max;
                while(lo + 1 < hi){
                    int mid = (lo + hi) / 2;
                    if(last[mid] >= nums[i]){
                        hi = mid;
                    }else{
                        lo = mid + 1;
                    }
                }
                if(last[lo] > nums[i]){
                    last[lo] = nums[i];
                }else{
                    last[hi] = nums[i];
                }
            }
        }
        
        return max;
    }


}
