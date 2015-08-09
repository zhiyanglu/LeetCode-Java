import java.util.Stack;


public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestValidParentheses().longestValidParentheses("()()"));
	}

	
	/**
	 * DP O(n) solution
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s){
		if(s.length() < 2) return 0;
		int[] opt = new int[s.length()];
		int max = 0;

		for(int i = 1; i < opt.length; i++){
			char c = s.charAt(i);
			if(c == '('){
				if(s.charAt(i-1) == ')')
					opt[i] = opt[i-1];
				else
					opt[i] = 0;
			}
			else if(c == ')'){
				if(s.charAt(i-1) == '(')
					opt[i] = opt[i-1] + 2;
				else
					if(i-opt[i-1] > 0 && s.charAt(i-opt[i-1] - 1) == '(')
						opt[i] = opt[i-opt[i-1] - 1] + opt[i-1] + 2;
					else
						opt[i] = 0;
				max = Math.max(max, opt[i]);
					
			}
		}
		
		return max;
	}
	
	/**
	 * O(n) solution using stack
	 * @param s
	 * @return
	 */
    public int longestValidParentheses2(String s) {
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
