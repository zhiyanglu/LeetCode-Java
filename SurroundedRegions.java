import java.util.LinkedList;


public class SurroundedRegions {

	
	/*
	 * A bfs solution. Push border 'O' into queue and do BFS
	 * on neighbor 'O' points
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'O','X','X','X','X'},
				{'X','X','O','X','O'},
				{'X','O','O','X','O'},
				{'X','X','O','X','O'},
				{'X','X','X','X','X'},
				{'X','O','X','O','X'}
		};
		
		new SurroundedRegions().solve(board);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public class Point{
		public int x;
		public int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	/**
	 * BFS iterative solution
	 * @param board
	 */
    public void solve(char[][] board) {
    	if(board == null || board.length == 0) return;
    	
    	LinkedList<Point> queue = new LinkedList<Point>();
    	
    	for(int i = 0; i < board[0].length; i++){
    		if(board[0][i] == 'O'){
    			board[0][i] = 'U';
    			queue.add(new Point(0, i));
    		}
    		if(board[board.length - 1][i] == 'O'){
    			board[board.length - 1][i] = 'U';
    			queue.add(new Point(board.length - 1, i));    			
    		}

    	}
    	for(int i = 0; i < board.length; i++){
    		if(board[i][0] == 'O'){
    			board[i][0] = 'U';
    			queue.add(new Point(i, 0));
    		}
    		if(board[i][board[0].length - 1] == 'O'){
    			board[i][board[0].length - 1] = 'U';
    			queue.add(new Point(i, board[0].length - 1));
    		}
    	}
    	
    	while(!queue.isEmpty()){
    		Point p = queue.poll();
    		
    		if(p.x > 0 && board[p.x - 1][p.y] == 'O'){
    			board[p.x-1][p.y] = 'U';
    			queue.add(new Point(p.x - 1, p.y));
    		}
    		if(p.x < board.length - 1 && board[p.x + 1][p.y] == 'O'){
    			board[p.x+1][p.y] = 'U';
    			queue.add(new Point(p.x + 1, p.y));
    		}
    		if(p.y > 0 && board[p.x][p.y - 1] == 'O'){
    			board[p.x][p.y-1] = 'U';
    			queue.add(new Point(p.x, p.y-1));
    		}
    		if(p.y < board[0].length - 1 && board[p.x][p.y + 1] == 'O'){
    			board[p.x][p.y+1] = 'U';
    			queue.add(new Point(p.x, p.y+1));
    		}
    	}
    	
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = board[i][j] == 'U' ? 'O' : 'X';
			}
		}    	
    }
    
    /**
     * Recursive DFS solution
     * @param board
     */
    public void solve2(char[][] board) {
        if(board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            fill(board, i, 0);
        }
        for(int i = 0; i < m; i++){
            fill(board, i, n-1);
        }
        for(int i = 0; i < n; i++){
            fill(board, 0, i);
        }
        for(int i = 0; i < n; i++){
            fill(board, m-1, i);
        }
    
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'M')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
        
    }
    private void fill(char[][] board, int x, int y){
        if(board[x][y] == 'M' || board[x][y] == 'X') return;
        board[x][y] = 'M';
        if(x > 1) fill(board, x-1, y);
        if(x < board.length-2) fill(board, x+1, y);
        if(y > 1) fill(board, x, y-1);
        if(y < board[0].length-2) fill(board, x, y+1);
    }

}
