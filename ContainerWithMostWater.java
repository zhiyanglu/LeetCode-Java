/**
 * Given n non-negative integers a1, a2, ..., an, where each represents 
 * a point at coordinate (i, ai). n vertical lines are drawn such that 
 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container 
 * contains the most water.
 * @author Lu
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * O(n) solution. Traverse from side to center
	 * 
	 */
	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length;
		while(left < right){
			max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
			if(height[left] < height[right])
				left++;
			else
				right--;
		}		
		return max;
    }

}
