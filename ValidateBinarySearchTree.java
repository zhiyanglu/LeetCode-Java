import java.util.Stack;


public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		System.out.println(new ValidateBinarySearchTree().isValidBST(root));
	}
	
	Stack<TreeNode> stack;
		
	/*
	 * use in-order traverse to validate
	 * Solution 1. Use stack. O(n) space
	 */
    public boolean isValidBST(TreeNode root) {
        stack = new Stack();
    	return isValidBSThelper(root);
    }
    
    public boolean isValidBSThelper(TreeNode root){
    	if(root == null) return true;
    	
    	boolean left = isValidBSThelper(root.left);
    	if(!stack.isEmpty() && root.val <= stack.peek().val) return false;
    	else stack.push(root);
    	boolean right = isValidBSThelper(root.right);
    	
    	return left && right;
    }

    /**
     * BFS root with a valid region to each child
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        // write your code here
        long min = (long)Integer.MIN_VALUE - 1;
        long max = (long)Integer.MAX_VALUE + 1;
        return isValidBST(root, min, max);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

}
