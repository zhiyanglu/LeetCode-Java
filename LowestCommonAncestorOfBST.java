/**
 * Given a binary search tree (BST), find the lowest common 
 * ancestor (LCA) of two given nodes in the BST.
 * @author Lu
 *
 */
public class LowestCommonAncestorOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while(true){
        	if(min <= node.val && node.val <= max) return node;
        	if(node.left != null && node.val > max) node = node.left;
        	if(node.right != null && node.val < min) node = node.right;
        }
    }


}
