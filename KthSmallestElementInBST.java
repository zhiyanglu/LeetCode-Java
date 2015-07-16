import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to 
 * find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often 
 * and you need to find the kth smallest frequently? How would 
 * you optimize the kthSmallest routine?
 * @author Lu
 *
 */
public class KthSmallestElementInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * O(n) solution
	 * @param root
	 * @param k
	 * @return
	 */
    public int kthSmallest(TreeNode root, int k) {
    	List<Integer> list = new ArrayList<Integer>();
    	findKth(root, list);
    	return list.get(k-1);
    }
    private void findKth(TreeNode root, List list){
    	if(root == null) return;
    	findKth(root.left, list);
    	list.add(root.val);
    	findKth(root.right, list);
    }
    
    /**
     * O(k) solution using in-order traverse based on stack
     */
    public int kthSmallest2(TreeNode root, int k){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(root != null){
    		stack.push(root);
    		root = root.left;
    	}
    	
    	while(k-- > 0){
    		TreeNode n = stack.pop();
    		n = n.right;
    		while(n != null){
    			stack.push(n);
    			n = n.left;
    		}
    	}
    	return stack.peek().val;
    }

}
