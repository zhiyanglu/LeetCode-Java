import java.util.Stack;


public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/..."));
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
	
	/**
	 * Solution without using split
	 * @param path
	 * @return
	 */
    public String simplifyPath2(String path) {
        // Write your code here
        
        Stack<String> stack = new Stack<String>();
        int index = 0;
        while(index < path.length()){
            while(index < path.length() && path.charAt(index) == '/'){
                index++;
            }
            String s = "";
            while(index < path.length() && path.charAt(index) != '/'){
                s += path.charAt(index);
                index++;
            }
            if(s.equals(".")) continue;
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(s.length() != 0){
                stack.push(s);
            }
        }
        
        if(stack.isEmpty()) return "/";
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, '/' + stack.pop());
        }
        
        return sb.toString();
    }


}
