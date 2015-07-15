/**
 * Given a binary tree, find the lowest common ancestor (LCA) 
 * of two given nodes in the tree.
 * @author Lu
 *
 */
public class LowestCommonAncestorOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null || root == p || root == q) return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p ,q);
    	if(left != null && right != null)
    		return root;
    	else
    		return left == null ? right : left;
    }

}
