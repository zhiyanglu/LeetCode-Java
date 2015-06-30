/**
 * You are a professional robber planning to 
 * rob houses along a street. Each house has 
 * a certain amount of money stashed, the only 
 * constraint stopping you from robbing each of 
 * them is that adjacent houses have security 
 * system connected and it will automatically 
 * contact the police if two adjacent houses were 
 * broken into on the same night.
 * Given a list of non-negative integers representing
 * the amount of money of each house, determine the
 * maximum amount of money you can rob tonight without
 * alerting the police.
 * @author Lu
 *
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Optimized O(1) space solution
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums){
		int prev = 0;
		int prevprev = 0;
		
		for(int i = 0; i < nums.length; i++){
			int temp = prev;
			prev = Math.max(prevprev + nums[i], prev);
			prevprev = temp;
		}
		
		return prev;
	}
	
	/**
	 * DP O(n) complexity O(n) space solution
	 * @param num
	 * @return
	 */
    public int rob2(int[] num) {
        if(num.length < 1) return 0;
        if(num.length == 1) return num[0];
        if(num.length >= 2) num[1] = Math.max(num[0], num[1]);

        for(int i = 2; i < num.length; i++){
            num[i] = Math.max(num[i - 1], num[i - 2] + num[i]);
        }
        
        return num[num.length - 1];
    }

}
