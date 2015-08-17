import java.util.ArrayList;
import java.util.List;


public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NQueens().solveNQueens(4));
	}
	
	List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
    	res = new ArrayList();
    	int[][] board = new int[n][n];
    
    	solve(board, 0, n);
    	return res;
    }
    private void solve(int[][] board, int index, int n){
    	if(index == n){
    		List<String> list = new ArrayList();
    		for(int i = 0; i < n; i++){
    			String row = "";
    			for(int j = 0; j < n; j++){
    				row += board[i][j] == 0 ? '.' : 'Q';
    			}
    			list.add(row);
    		}
    		res.add(list);
    		return;
    	}
    	
    	for(int i = 0; i < n; i++){
    		board[index][i] = 1;
    		if(isValid(board, index, i, n))
    			solve(board, index+1, n);
    		board[index][i] = 0;
    	}
    }
    private boolean isValid(int[][] board, int x, int y, int n){
    	for(int i = 0; i < n; i++){
    		if(board[x][i] == 1 && i != y) return false;
    		if(board[i][y] == 1 && i != x) return false;
    	}
    	int i = x, j = y;
    	while(++i < n && ++j < n){
    		if(board[i][j] == 1) return false;
    	}
    	i = x; j = y;
    	while(--i >= 0 && --j >= 0){
    		if(board[i][j] == 1) return false;
    	}
    	i = x; j = y;
    	while(++i < n && --j >= 0){
    		if(board[i][j] == 1) return false;    		
    	}
    	i = x; j = y;
    	while(--i >= 0 && ++j < n){
    		if(board[i][j] == 1) return false;    		
    	}
    	
    	return true;

    }


}
