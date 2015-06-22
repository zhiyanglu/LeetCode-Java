import java.util.Stack;


public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}
	
	public static String simplifyPath(String path){
		String[] elements = path.split("/+");
		if(elements.length == 0) return "/";
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < elements.length; i++){
//			System.out.println(elements[i]);
			if(elements[i].equals(".")){
				continue;
			}else if(elements[i].equals("..")){
				if(!stack.isEmpty()) stack.pop();
			}else if(elements[i].compareTo("") != 0){
				stack.push(elements[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) return "/";
//		System.out.println(stack.size());
		while(!stack.isEmpty()){
			sb.insert(0, "/" + stack.pop());
		}
		
		return sb.toString();
	}

}
