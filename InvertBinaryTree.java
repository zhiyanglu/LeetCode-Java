
public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;

    	TreeNode left = root.left;
    	root.left = root.right;
    	root.right = left;
    	invertTree(root.left);
    	invertTree(root.right);
    	return root;
    }

}
