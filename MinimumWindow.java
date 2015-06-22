import java.util.HashMap;
import java.util.HashSet;


public class MinimumWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow2("ab", "b"));
	}
	    
    
    public static String minWindow(String s, String t){
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
    	HashMap<Character, Integer> table = new HashMap();
    	HashMap<Character, Integer> set = new HashMap();
    	
    	int setLen = 0;
    	int resLen = 0;
    	
    	for(int i = 0; i < tt.length; i++){
    		if(set.containsKey(tt[i])){
    			set.put(tt[i], set.get(tt[i]) + 1);
    			setLen++;
    		}else{
        		set.put(tt[i], 1);    		
        		setLen++;
    		}
    	}
    	
    	int minStart = 0;
    	int minEnd = ss.length - 1;
    	int slow = 0;
    	int fast = -1;
    	
    	while(slow < ss.length){
    		if(set.containsKey(ss[slow])){
    			table.put(ss[slow], 1);
    			resLen++;
    			fast = slow + 1;
    			break;
    		}else{
    			slow++;
    		}
    	}
    	
    	if(slow == ss.length) return "";
    	
    	while(fast < ss.length){

    		if(set.containsKey(ss[fast])){
//				char cur_fast = ss[fast];
//				char cur_slow = ss[slow];

    			if(table.containsKey(ss[fast]) && ss[slow] == ss[fast] && set.get(ss[slow]) <= table.get(ss[fast])){
    				//move slow to next character with only 1 and compare min length
    				table.put(ss[slow], table.get(ss[slow]) + 1);
    				resLen++;
    				while(slow <= fast){
    					if(table.containsKey(ss[slow])){
    						if(table.get(ss[slow]) <= set.get(ss[slow])){
    							break;
    						}else{
        						table.put(ss[slow], table.get(ss[slow]) - 1);
        						resLen--;
    						}    						
    					}
						slow++;
    				}
    				if(resLen == setLen){
    					if(fast - slow < minEnd - minStart){
    						minStart = slow;
    						minEnd = fast;
    					}
    				}
    				
    				
    			}else{
    				//do not move slow, put char to table
    				if(table.containsKey(ss[fast])){
    					table.put(ss[fast], table.get(ss[fast]) + 1);
    					resLen++;
    				}else{
    					table.put(ss[fast], 1);
    					resLen++;
    				}
    				//if set.size = table.size, compare min length
    				if(setLen == resLen){
    					if(fast - slow < minEnd - minStart){
    						minStart = slow;
    						minEnd = fast;
    					}
    				}
    			}
    		}
    		fast++;
    	}
    	
    	for(Character key : set.keySet()){
    		if(!table.containsKey(key) || table.get(key) < set.get(key)){
    			return "";
    		}
    	}
    	return s.substring(minStart, minEnd + 1);
    	

    }
    
    public static String minWindow2(String s, String t){
    	String result = "";
    	if(s.isEmpty() || t.isEmpty()){
    		return result;
    	}
    	char[] S = s.toCharArray();
    	char[] T = t.toCharArray();
    	
    	
    	HashMap<Character, Integer> map = new HashMap();
    	HashMap<Character, Integer> window = new HashMap();
    	for(int i = 0; i < T.length; i++){
    		char c = T[i];
    		if(!map.containsKey(c)){
    			map.put(c, 1);
    			window.put(c, 0);
    		}else{
    			map.put(c, map.get(c) + 1);
    		}
    	}
    	
    	int start = 0;
    	int count = 0;
    	int minLength = Integer.MAX_VALUE;
    	int minStart = 0;
    	
    	for(int end = 0; end < S.length; end++){
    		char c = S[end];
    		if(map.containsKey(c)){
    			if(window.get(c) < map.get(c)){
    				count++;
    			}
    			window.put(c, window.get(c) + 1);
    		}
    		
    		if(count >= T.length){
    			while((!map.containsKey(S[start])) || window.get(S[start]) > map.get(S[start])){
    				
    				if(window.containsKey(S[start])){
    					window.put(S[start], window.get(S[start]) - 1);
    				}
					start++;

    			}
    			if(end - start + 1 < minLength){
    				minStart = start;
    				minLength = end - start + 1;
    			}
    			
    			count--;
    			window.put(S[start], window.get(S[start]) - 1);
    			start++;    			
    		}
    		
    	}
    	
    	if(minLength == Integer.MAX_VALUE) return "";
    	return s.substring(minStart, minStart + minLength);    	
    }
    
    
}
