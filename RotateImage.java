/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * @author Lu
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(a);
		new RotateImage().rotate(a);
		printMatrix(a);
	}

	public static void printMatrix(int[][] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * in-place solution
	 * @param matrix
	 */
	public void rotate(int[][] matrix){
		if(matrix == null || matrix.length == 0) return;
		int len = matrix.length;
		for(int i = 0; i < len/2; i++){
			for(int j = i; j < len-1-i; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len-j-1][i];
				matrix[len-j-1][i] = matrix[len-1-i][len-1-j];
				matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
				matrix[j][len-1-i] = temp;
			}
		}
	}
	
	/**
	 * Not in-place solution
	 * @param matrix
	 */
	public void rotate2(int[][] matrix){
		if(matrix == null || matrix.length == 0) return;
		int len = matrix.length;
		int[][] copy = new int[len][len];
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				copy[i][j] = matrix[len - 1 - j][i];
			}
		}
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				matrix[i][j] = copy[i][j];
			}
		}
	}

}
