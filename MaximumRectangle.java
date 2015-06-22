import java.util.Arrays;


public class MaximumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {
				{'0','0','0','1','0','0','0'},
				{'0','0','1','1','1','0','0'},
				{'0','1','1','1','1','1','0'}
		};
		new MaximumRectangle().maximalRectangle(matrix);
	}

	
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int[] height = new int[n];
        
        int maxA = 0;
        
        //start from first row.
        for(int i = 0; i < m; i ++){
        	int cur_left = 0, cur_right = n;
        	
        	// compute height (can do this from either side)
        	for(int j = 0; j < n; j++){
        		if(matrix[i][j] == '1') height[j]++;
        		else height[j] = 0;
        	}
        	
        	// compute left (from left to right)
        	for(int j = 0; j < n; j++){
        		if(matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
        		else {left[j] = 0; cur_left = j + 1;}
        	}
        	
        	// compute right (from right to left)
        	for(int j = n - 1; j >= 0; j--){
        		if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
        		else {right[j] = n; cur_right = j;}
        	}
        	
        	// compute the area of rectangle (can do this from either side)
        	for(int j = 0; j < n; j++){
        		maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
        	}
        	
        }
        return maxA;
    }

}
