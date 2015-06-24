import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(new WordBreakII().wordBreak("catsanddog", dict));
		
	}
	
	
	//map contains a string to all its valid partitions
	HashMap<String, List<String>> map= new HashMap<String, List<String>>();	
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> list = new ArrayList<String>();
		if(map.containsKey(s)) return map.get(s);
		
		//a list stored partitioned s
		for(int i = 0; i <= s.length(); i++){
			String left = s.substring(0, i);
			String right = s.substring(i);
			if(dict.contains(left)){
				List<String> partitioned_right = wordBreak(right, dict);
				for(String rightpart : partitioned_right){
					list.add(left + " " + rightpart);
				}
				if(right.length() == 0) list.add(left);
			}
		}
		map.put(s, list);
		return list;
	
	}
	
	
	/*
	 * Scan the the string from the tail
	 * Build possible solution for the current index based on DP results
	 * Return the solution when index==0
	 * Runs LTE on "baaaaaaaaaaaaaaaaaaaaaaaa"
	 */
    public List<String> wordBreak2(String s, Set<String> wordDict) {
    	Map<Integer, List<String>> validMap = new HashMap();
    	
    	//initialize the valid values
    	List<String> l = new ArrayList<String>();
    	l.add("");
    	validMap.put(s.length(), l);
    	
    	//generate solutions from the end
    	for(int i = s.length() - 1; i >= 0; i--){
    		List<String> values = new ArrayList<String>();
    		for(int j = i + 1; j <= s.length(); j++){
    			if(wordDict.contains(s.substring(i, j))){
    				for(String word : validMap.get(j)){
    					values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
    				}
    			}
    		}
    		validMap.put(i, values);
    	}
    	
    	return validMap.get(0);
    }

}
