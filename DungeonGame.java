import java.util.Arrays;

/*
 * The demons had captured the princess (P) and 
 * imprisoned her in the bottom-right corner of 
 * a dungeon. The dungeon consists of M x N rooms
 * laid out in a 2D grid. Our valiant knight (K) 
 * was initially positioned in the top-left room 
 * and must fight his way through the dungeon to 
 * rescue the princess.The knight has an initial 
 * health point represented by a positive integer. 
 * If at any point his health point drops to 0 or 
 * below, he dies immediately.Some of the rooms are
 * guarded by demons, so the knight loses health 
 * (negative integers) upon entering these rooms; 
 * other rooms are either empty (0's) or contain magic 
 * orbs that increase the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, 
 * the knight decides to move only rightward or downward in each step.
 */
public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{0, 0}};
		new DungeonGame().calculateMinimumHP(a);
	}
	
	/*
	 * O(mn) complexity and O(n) space DP solution
	 */
    public int calculateMinimumHP(int[][] dungeon) {
    	int m = dungeon.length;
    	int n = dungeon[0].length;
    	int[] h = new int[n+1];
    	Arrays.fill(h, Integer.MAX_VALUE);
    	
    	//only set h[n-1] = 1. Right side col is always Max_Int
    	h[n - 1] = 1;

    	for(int i = m - 1; i >= 0; i--){
    		for(int j = n - 1; j >= 0; j--){
    			h[j] = Math.min(h[j], h[j+1]) - dungeon[i][j];
    			h[j] = Math.max(h[j], 1);
    		}
    	}
    	return h[0];
    	
    }

	
	/*
	 * Cleaner O(mn) complexity O(mn) space Solution
	 */
    public int calculateMinimumHP3(int[][] dungeon) {
    	int m = dungeon.length;
    	int n = dungeon[0].length;
    	
    	int[][] h = new int[m+1][n+1];
    	for(int i = 0; i < h[m].length; i++){
    		h[m][i] = Integer.MAX_VALUE;
    	}
    	for(int i = 0; i < h.length; i++){
    		h[i][n] = Integer.MAX_VALUE;
    	}
    	h[m][n-1] = 1;
    	h[m-1][n] = 1;
    	h[m-1][n-1] = Math.max(1, -dungeon[m-1][n-1]);
    	for(int i = m-1; m >= 0; i--){
    		for(int j = n-1; n >= 0; j--){
    			h[i][j] = Math.min(h[i+1][j], h[i][j+1]) - dungeon[i][j];
    			h[i][j] = Math.max(h[i][j], 1);
    		}
    	}
    	
    	return h[0][0];
    }
	
	
	/*
	 *  create a health array using dungeon.
	 *  return health[0][0]
	 *  1. First compute the last row and last col of health[][]
	 *  2. Compute the remaining grids
	 */
    public int calculateMinimumHP2(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[][]	health = new int[row][col];
        
        if(dungeon[row - 1][col-1] >= 0){
        	health[row - 1][col-1] = 1;
        }else{
        	health[row-1][col-1] = 1 - dungeon[row-1][col-1];
        }
        
        for(int i = row - 2; i >= 0; i--){
        	health[i][col-1] = health[i + 1][col-1] - dungeon[i][col-1];
        	if(health[i][col-1] < 1) health[i][col-1] = 1;
        }
        
        for(int i = col - 2; i >= 0; i--){
        	health[row - 1][i] = health[row-1][i+1] - dungeon[row-1][i];
        	if(health[row-1][i] < 1) health[row-1][i] = 1;        	
        }
        
        for(int i = row - 2; i >= 0; i--){
        	for(int j = col - 2; j >= 0; j--){
        		int a = Math.max(health[i+1][j] - dungeon[i][j], 1);
        		int b = Math.max(health[i][j+1] - dungeon[i][j], 1);
        		health[i][j] = Math.min(a, b);
        	}
        }
        
        return health[0][0];
    }
}
