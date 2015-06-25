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

	}
	
	
	/*
	 *  create a health array using dungeon.
	 *  return health[0][0]
	 *  1. First compute the last row and last col of health[][]
	 *  2. Compute the remaining grids
	 */
    public int calculateMinimumHP(int[][] dungeon) {
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
