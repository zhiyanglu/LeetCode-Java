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


}
