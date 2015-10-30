import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ClosetBSTValueII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		new ClosetBSTValueII().closestKValues(root, 2.5, 4);
		String a = "aa";
		StringBuilder sb = new StringBuilder();
	}

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        predessor(root, target, s1);
        successor(root, target, s2);
        
        while(k-- > 0){
        	if(s1.size() > 0 && s2.size() > 0){
            	if(Math.abs(target - s1.peek()) < Math.abs(target - s2.peek())){
            		res.add(s1.pop());
            	}else{
            		res.add(s2.pop());
            	}        		
        	}else{
        		res.add(s1.size() > 0 ? s1.pop() : s2.pop());
        	}
        }
        
        return res;
    }
    
    private void successor(TreeNode root, double target, Stack<Integer> s2){
        if(root == null) return;
        if(root.val > target){
        	successor(root.right, target, s2);
        	s2.push(root.val);
        	successor(root.left, target, s2);
        }else{
        	successor(root.left, target, s2);
        }
    }
    
    private void predessor(TreeNode root, double target, Stack<Integer> s1){
        if(root == null) return;
        if(root.val <= target){
            predessor(root.left, target, s1);
            s1.push(root.val);
            predessor(root.right, target, s1);
        }else{
            predessor(root.left, target, s1);
        }
    }

}
