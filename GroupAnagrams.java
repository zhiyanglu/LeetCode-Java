import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * @author Lu
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'c','a'};
	}
	
	
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList();
    	Map<String, List> map = new HashMap();
    	Arrays.sort(strs);
    	for(String s : strs){
    		char[] c = s.toCharArray();
    		Arrays.sort(c);
    		String key = new String(c);
    		if(!map.containsKey(key)){
    			map.put(key, new ArrayList<String>());
    			res.add(map.get(key));
    		}
    		map.get(key).add(s);    		    		
    	}    	
    	
    	return res;
    }


}
