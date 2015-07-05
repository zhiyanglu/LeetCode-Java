import java.util.Stack;


public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BasicCalculator().calculate("1+2-(3-2)"));
	}
	
	public int calculate(String s){
		Stack<Integer> stack = new Stack();
		
		int result = 0;
		int number = 0;
		int sign = 1;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = 10 * number + c - '0';
			}else if(c == '+'){
				result += sign * number;
				number = 0;
				sign = 1;
			}else if(c == '-'){
				result += sign * number;
				number = 0;
				sign = -1;
			}else if(c == '('){
				//we push the result first, then sign;
				stack.push(result);
				stack.push(sign);				
				//reset the sign and result for the value in the parenthesis
				sign = 1;
				result = 0;
			}else if(c == ')'){
				result += sign * number;
				number = 0;
				result *= stack.pop();
				result += stack.pop();
			}
		}
		
		if(number != 0) result += sign * number;
		return result;
	}
	
	
    public int calculate2(String s) {
    	char[] c = s.toCharArray();
    	Stack<Integer> stack = new Stack();
    	int res = 0;
    	int sign = 1;
    	stack.push(1);
    	for(int i = 0; i < c.length; i++){
    		if(c[i] == ' ') continue;
    		else if (c[i] == '('){
    			stack.push(stack.peek() * sign);
    			sign = 1;
    		}
    		else if(c[i] ==	')') stack.pop();
    		else if(c[i] == '+') sign = 1;
    		else if(c[i] == '-') sign = -1;
    		else{
    			int temp = c[i] - '0';
    			while(i + 1 < c.length && Character.isDigit(c[i+1])){
    				temp = temp * 10 + c[i + 1] - '0';
    			}
    			res += sign * stack.peek() * temp;
    		}
    	}
    	return res;
    }
}
