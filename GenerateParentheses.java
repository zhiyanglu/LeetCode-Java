import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author Lu
 *
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		new GenerateParentheses().generateParenthesis(3);
	}
	
	
	List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        generateParenthesis(n, 0, "");
        return result;
    }
    private void generateParenthesis(int n, int unmatched, String s){
    	if(n == 0 && unmatched == 0 && s.length() > 0){
    		result.add(s);
    		return;
    	}
    	
    	if(unmatched > 0){
    		generateParenthesis(n, unmatched-1, s+')');
    	}
    	if(n > 0) {
    		generateParenthesis(n-1, unmatched+1, s+'(');
    	}
    }
    
    /**
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        ArrayList<String> list = new ArrayList<String>();
        
        if(n == 0){
            list.add("");
        }else{
            for(int i = 0; i <= n-1; i++){
                List<String> innerlist = generateParenthesis(i);
                List<String> taillist = generateParenthesis(n - 1 - i);
                for(String inner : innerlist){
                    for(String tail : taillist){
                        list.add("(" + inner + ")" + tail);
                    }
                }
            }
        }
        return list;
    }

}
