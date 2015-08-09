import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words = {"fooo","barr","wing","ding","wing"};
		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
	}
	
	
	
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new ArrayList();
		if(words.length == 0 || s.length() < words.length * words[0].length()) return res;
		
		int N = s.length(), M = words.length, K = words[0].length();
		
		
		return res;
	}
	
	/**
	 * O(nm) solution using hashmap
	 */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList();
        int len = words[0].length();
        if(s.length() < words.length * len) return res;
        Map<String, Integer> map = new HashMap();
        for(String word : words)
        	if(map.containsKey(word)) map.put(word, map.get(word)+1);
        	else map.put(word, 1);
        
        for(int i = 0; i < s.length() - len*words.length + 1; i++){
            if(map.containsKey(s.substring(i, i+len))){
            	Map<String, Integer> copy = new HashMap(map);
            	int count = 0;
            	for(int j = i; j < s.length()-len+1; j+=len){
            		String word = s.substring(j, j+len);
            		if(copy.containsKey(word) && copy.get(word) > 0){
            			copy.put(word, copy.get(word)-1);
            			count++;
            		}else{
            			break;
            		}
            	}
            	if(count == words.length) res.add(i);
            }
        }

        return res;
    }

}
