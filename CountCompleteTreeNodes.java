/**
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly 
 * the last, is completely filled, and all nodes in the 
 * last level are as far left as possible. It can have between 
 * 1 and 2^h nodes inclusive at the last level h.
 * 
 * @author Lu
 *
 */
public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * Recursive O(logn * logn) solution
	 */
	public int countNodes(TreeNode root){
		int h = height(root);
		if(h < 0) return 0;
		if(height(root.right) == h - 1){
			return countNodes(root.right) + (1 << h);
		}else{
			return countNodes(root.left) + (1 << (h - 1));
		}
	}
	
	/**
	 * Iterative O(logn * logn) soluiton
	 * 
	 * Find the height of the tree by going left last level 
	 * can have at most 2 ^ h nodes do binary search to see 
	 * if the right child tree has the same height as the parent:
	 * 1. If it is same, the left child tree has 2 ^ h nodes 
	 *    include parent and keep finding on right child tree
	 * 2. If it is not same, the right child tree has 2 ^ h - 1 
	 *    nodes include the parent and keep finding on left child tree
	 */
	private int height(TreeNode root){
		if(root == null) return -1;
		else
			return height(root.left) + 1;
	}
	public int countNodes2(TreeNode root){
		if(root == null) return 0;
		int h = height(root);
		int nodes = 0;
		while(root != null){
			if(height(root.right) == h - 1){
				nodes += 1 << h;
				root = root.right;
			}else{
				nodes += 1 << h - 1;
				root = root.left;
			}
			h--;
		}
		return nodes;
	}
	
	
	/**
	 * O(n) brute force solution
	 */
	private int num;
    public int countNodes1(TreeNode root) {        
        num = 0;
        count(root);        
        return num;
    }
    private void count(TreeNode root){
    	if(root == null) return;
    	num++;
    	count(root.left);
    	count(root.right);
    }


}
