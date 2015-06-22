import java.util.Stack;


public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("(())))())("));
	}

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '('){
        		stack.push(i);
        	}else{				//is ')'
        		if(stack.isEmpty()){
        			stack.push(i);
        		}else if(s.charAt(stack.peek()) == ')'){
        			stack.push(i);
        		}else{
        			stack.pop();        			
        			int start = stack.isEmpty() ? -1 : stack.peek();
        			maxLen = Math.max(maxLen, i - start);
        		}
        	}
        }
    	
    	return maxLen;
    }

}
