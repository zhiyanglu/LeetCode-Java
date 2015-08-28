import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
  All root-to-leaf paths are:
  
  ["1->2->5", "1->3"]
 * @author Lu
 *
 */
public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
	
	
    List<String> res;
    /**
     * Recursive solution
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();

        dfs(root, sb);
        
        return res;
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null) return;
        if(sb.length()>0)
            sb.append("->");
        sb.append(root.val);
        
        if(root.left == null && root.right == null)
            res.add(sb.toString());

        dfs(root.left, sb);
        dfs(root.right, sb);
        
        if(sb.length() > 3){
            while(sb.charAt(sb.length()-1) != '>')
                sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
