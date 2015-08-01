/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 		Integers in each row are sorted in ascending from left to right.
 * 		Integers in each column are sorted in ascending from top to bottom.
 *
 */
public class Search2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
				};
		
		new Search2DMatrixII().searchMatrix(matrix, 19);
	}
	
	/**
	 * O(m+n) solution
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0) return false;
    	int i = 0;
    	int j = matrix[0].length - 1;
    	while(i < matrix.length && j >= 0){
    		int num = matrix[i][j];
    		if(num == target) return true;
    		else if(num < target) i++;
    		else j--;
    	}
    	return false;
    }


}
