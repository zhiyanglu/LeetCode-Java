
public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				};

		SudokuSolver s = new SudokuSolver();

		s.solveSudoku(board);
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}

    public void solveSudoku(char[][] board) {
    	solveSudokuHelper(board);
    }
    
    public boolean solveSudokuHelper(char[][] board){
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board.length; j++){
        		if(board[i][j] == '.'){
        			for(char c = '1'; c <= '9'; c++){
        				
        				if(isValid(board, i, j, c)){
        					board[i][j] = c;
        					if(solveSudokuHelper(board)){
        						return true;
        					}else{
        						board[i][j] = '.';
        					}
        				}
        				
        			}
        			
        			return false;
        		}
        	}
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c){
    	for(int row = 0; row < board.length; row++){
    		if(board[row][j] == c) return false;
    	}
    	for(int col = 0; col < board.length; col++){
    		if(board[i][col] == c) return false;
    	}
    	for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
    		for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++){
    			if(board[row][col] == c) return false;
    		}
    	}
    	
    	return true;
    }

}
