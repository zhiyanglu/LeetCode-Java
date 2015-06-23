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
}
