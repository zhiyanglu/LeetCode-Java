import java.util.Stack;


public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * No error check stack solution. Input must be valid
	 */
	public int evalRPN(String[] tokens){
		Stack<Integer> stack = new Stack();
		for(int i = 0; i < tokens.length; i++){
			
			switch(tokens[i]){
				case "+":
					stack.push(stack.pop()+stack.pop());
					break;
				case "-":
					stack.push(-stack.pop()+stack.pop());
					break;
				case "*":
					stack.push(stack.pop()*stack.pop());
					break;
				case "/":
					int div = stack.pop();
					stack.push(stack.pop() / div);
					break;
				default:
					stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}

}
