/**
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, 
 * the thief has found himself a new place for 
 * his thievery so that he will not get too much 
 * attention. This time, all houses at this place 
 * are arranged in a circle. That means the first 
 * house is the neighbor of the last one. Meanwhile, 
 * the security system for these houses remain the 
 * same as for those in the previous street.
 * Given a list of non-negative integers representing
 * the amount of money of each house, determine the 
 * maximum amount of money you can rob tonight without 
 * alerting the police.
 * @author Lu
 *
 */
public class HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 1, 1, 5};
		System.out.println(new HouseRobberII().rob(a, 0, a.length));
	}
	
	/**
	 * A smaller solution to solve HouseRobber I
	 */
	private int rob(int[] nums, int start, int end){
		int prev = 0;
		int prevprev = 0;
		
		for(int i = start; i < end; i++){
			int temp = prev;
			prev = Math.max(prevprev + nums[i], prev);
			prevprev = temp;
		}
		
		return prev;
	}

	/**
	 * For a circulated path, return the maximum of
	 * first house excluded and last house excluded
	 * @param num
	 * @return
	 */
    public int rob(int[] num) {
    	if(num.length == 1) return num[0];
    	return Math.max(rob(num, 0, num.length - 1),rob(num, 1, num.length));
    }

}
