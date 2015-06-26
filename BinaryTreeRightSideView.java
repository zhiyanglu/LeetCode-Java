import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it 
 * return the values of the nodes you can see ordered from top to bottom.
 * @author Lu
 */
public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.print(new BinaryTreeRightSideView().rightSideView(root));
	}
	
	
	/*
	 * Use BFS to traverse the tree.
	 * At each level visit node from right to left
	 * The first node at each level is the right most node
	 */
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> result = new ArrayList();
        if(root == null) return result;

    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(root);
        
        while(!queue.isEmpty()){
        	LinkedList<TreeNode> next_level = new LinkedList<TreeNode>();        	
        	result.add(queue.peek().val);
        	while(!queue.isEmpty()){
        		TreeNode node = queue.poll();
        		if(node.right != null){
        			next_level.add(node.right);
        		}
        		if(node.left != null){
        			next_level.add(node.left);
        		}
        	}
        	queue = next_level;
        }
        
        return result;
    }

}
