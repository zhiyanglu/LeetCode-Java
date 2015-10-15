
public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{1,1},{1,0}};
		new GameOfLife().gameOfLife(board);
	}
	
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                for(int x = Math.max(i-1, 0); x < Math.min(m, i+2); x++){
                    for(int y = Math.max(j-1, 0); y < Math.min(n, j+2); y++){
                        count += (board[x][y] % 2);	
                    }                	
                }
                
                count -= (board[i][j] % 2);
                if(board[i][j] % 2 == 1 && (count == 2 || count == 3)){
                    board[i][j] += 2;
                }
                if(board[i][j] % 2 == 0 && count == 3){
                    board[i][j] += 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = board[i][j] >> 1;
            
            
        return;
    }


}
