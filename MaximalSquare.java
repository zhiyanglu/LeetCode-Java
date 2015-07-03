import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find 
 * the largest square containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 * @author Lu
 *
 */
public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {
				
				{'1','0','1','0'},
				{'1','0','1','1'},
				{'1','0','1','1'},
				{'1','1','1','1'}
		};
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}

	/**
	 * O(n^2) complexity O(n) space DP solution
	 * 
	 */
	public int maximalSquare(char[][] matrix){
		int max = 0;
		if(matrix.length == 0) return 0;
		int[] opt = new int[matrix[0].length];
		for(int i = 0; i < opt.length; i++){
			opt[i] = matrix[0][i] - '0';
			if(opt[i] == 1) max = 1;
		}
		for(int i = 1; i < matrix.length; i++){
			int prev = matrix[i][0] - '0';
			for(int j = 1; j < matrix[0].length; j++){
				int temp = prev;
				if(matrix[i][j] == '0')
					prev = 0;
				else
					prev = Math.min(opt[j - 1], Math.min(opt[j], prev)) + 1;
				opt[j - 1] = temp;
				max = Math.max(max, prev);
			}
			opt[opt.length - 1] = prev;
		}
		return max * max;
	}
	
	/**
	 * O(n^2) complexity O(n^2) space DP solution
	 * opt[i][j] means the size of the square at point (i,j)
	 * when (i, j) is the left-bottom point in the square
	 * opt[i][j] = 0 if matrix[i][j] = 0;
	 * opt[i][j] = min(opt[i-1][j], opt[i][j-1], opt[i-1][j-1]) + 1
	 */
	public int maximalSquare2(char[][] matrix) {
	    if(matrix.length == 0) return 0;
		int max = 0;
		int[][] opt = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			opt[i][0] = matrix[i][0] - '0';
			if(opt[i][0] == 1) max = 1;
		}
		for(int i = 0; i < matrix[0].length; i++){
			opt[0][i] = matrix[0][i] - '0';
			if(opt[0][i] == 1) max = 1;
		}
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == '0') 
					opt[i][j] = 0;
				else
					opt[i][j] = Math.min(opt[i-1][j], Math.min(opt[i-1][j-1], opt[i][j-1])) + 1;
				
				max = Math.max(max, opt[i][j]);
			}
		}
		return max * max;
	}
	
	/**
	 * A DP solution based on MaximumRectangle
	 * @param matrix
	 * @return
	 */
	public int maximalSquare1(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);
		int[] height = new int[n];

		int maxA = 0;

		// start from first row.
		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;

			// compute height (can do this from either side)
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}

			// compute left (from left to right)
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}

			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}

			// compute the area of rectangle (can do this from either side)
			for (int j = 0; j < n; j++) {
				//find the minimum of width and height in a rectangle
				int len = Math.min(right[j] - left[j], height[j]);
				maxA = Math.max(maxA, len * len);
			}

		}
		return maxA;

	}
}
