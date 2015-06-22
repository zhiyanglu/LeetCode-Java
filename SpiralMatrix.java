import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	if(matrix == null) return list;
    	int m = matrix.length;
    	if(m == 0) return list;
    	int n = matrix[0].length;
    	
    	int x0 = 0, y0 = 0;
    	int x1 = m - 1, y1 = n - 1;
    	
    	while(x0 < x1 && y0 < y1){
    		int x = x0;
    		int y = y0;
    		while(y < y1) list.add(matrix[x][y++]);
    		while(x < x1) list.add(matrix[x++][y]);
    		while(y > y0) list.add(matrix[x][y--]);
    		while(x > x0) list.add(matrix[x--][y]);
    		
    		x0++;
    		y0++;
    		x1--;
    		y1--;    		
    		
    	}
    	
    	int x = x0;
    	int y = y0;
    	
    	if(x0 == x1 && y0 <= y1){
    		while(y <= y1) list.add(matrix[x][y++]);
    	}else if(y0 == y1 && x0 <= x1){
    		while(x <= x1) list.add(matrix[x++][y]);
    	}
    	
    	return list;
    }


}
