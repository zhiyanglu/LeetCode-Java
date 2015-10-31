
public class CountUniValueSubtrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		new CountUniValueSubtrees().countUnivalSubtrees(root);
	}


    int counts;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        counts = 0;
        
        count(root);
        
        return counts;
    }

    private boolean count(TreeNode root){
        if(root.left == null && root.right == null){
            counts++;
            return true;
        }
        boolean res = true;
        if(root.left != null){
        	boolean left = count(root.left);
            res = res && left && root.val == root.left.val;
        }
        if(root.right != null){
        	boolean right = count(root.right);
            res = res && right && root.val == root.right.val;
        }
        if(res) counts++;
        
        return res;
    }

}
