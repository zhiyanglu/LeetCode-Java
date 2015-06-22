
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * The thought is bottom-up
	 * first we need to get left and right tree max value 
	 * and make sure that they need to be larger than 0. Next 
	 * add them to current node value, compare to the total 
	 * max value and update the total max value. Finally return 
	 * current value with one of left or right max value (>=0).
	 */
	
	int max = 0;
	public int maxPathSum(TreeNode root){
		if(root == null) return 0;
		max = root.val;
		maxPathSumHelper(root);
		return max;
	}
	
	public int maxPathSumHelper(TreeNode root){
		if(root == null) return 0;
		
		int left = maxPathSumHelper(root.left);
		int right = maxPathSumHelper(root.right);
		left = left > 0 ? left : 0;
		right = right > 0 ? right : 0;
		int curMax = root.val + left + right;
		max = Math.max(max, curMax);
		return root.val + Math.max(left, right);
	}

}
