import java.util.Stack;


public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseWordsInAString().reverseWords(" the sky is blue "));
	}
	
	
	/*
	 * A solution without split() and trim()
	 */
	public String reverseWords(String s){
		char[] c = s.toCharArray();
		Stack<String> stack = new Stack();
		for(int i = 0; i < c.length; ){
			while(i < c.length && c[i] == ' '){
				i++;
			}
			StringBuilder sb = new StringBuilder();
			while(i < c.length && c[i] != ' '){
				sb.append(c[i]);
				i++;
			}
			if(sb.length() != 0){
				stack.push(sb.toString());				
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			if(stack.size() != 1)
				sb.append(stack.pop() + " ");
			else
				sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	
	/*
	 * A solution using Java Built-in function
	 */
	public String reverseWords2(String s){
		String[] words = s.split(" +");
		StringBuilder sb = new StringBuilder();
		for(int i = words.length - 1; i >= 0; i--){
			sb.append(words[i] + " ");
		}
		return sb.toString().trim();
	}

}
