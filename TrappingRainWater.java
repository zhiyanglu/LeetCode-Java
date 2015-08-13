/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author Lu
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap2(height));
	}

	
	
	/**
	 * Use level to maintain the current water level
	 * @param height
	 * @return
	 */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int level = 0;
        int sum = 0;
        
        while(left < right){
        	level = Math.max(Math.min(height[left], height[right]), level);
        	if(height[left] > height[right]){
        		sum += level - height[right];
        		right--;
        	}else{
        		sum += level - height[left];
        		left++;
        	}
        }
        return sum;
    }
    
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftmax = 0;
        int rightmax = 0;
        int sum = 0;
        
        while(left < right){
        	leftmax = Math.max(leftmax, height[left]);
        	rightmax = Math.max(rightmax, height[right]);
        	if(leftmax < rightmax){
        		sum += leftmax - height[left];
        		left++;
        	}else{
        		sum += rightmax - height[right];
        		right--;
        	}
        }
        
        return sum;
    }


}
