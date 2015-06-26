
public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
		new NumberOfIslands().numIslands(grid);
	}
	
	
	/*
	 * Traverse the grid, if the cell is 1, do DFS on the
	 * cell and mark all visited node x, increase the number
	 * of islands by 1 when return
	 */
	public int numIslands(char[][] grid){
		int islands = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == '1'){
					islands++;
					sink(grid, i, j);
				}
			}
		}
		return islands;
	}
	private void sink(char[][] grid, int x, int y){
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
			return;
		}
		if(grid[x][y] == '1'){
			grid[x][y] = 'x';
			sink(grid, x + 1, y); sink(grid, x, y + 1); 
			sink(grid, x - 1, y); sink(grid, x, y - 1);
		}
	}

}
