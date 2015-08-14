
public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isMatch2("aaa", "*aa"));

	}
	
	
	/**
	 * DP O(mn) space solution
	 */
    public boolean isMatch3(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        for(int i = 1; i < match.length; i++){
            match[i][0] = false;
        }
        for(int i = 1; i < match[0].length; i++){
            match[0][i] = match[0][i-1] && p.charAt(i-1) == '*';
        }
        
        for(int i = 1; i < match.length; i++){
            for(int j = 1; j < match[0].length; j++){
                if(match[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?'))
                    match[i][j] = true;
                if(match[i-1][j] && p.charAt(j-1)=='*')
                    match[i][j] = true;
                if(match[i][j-1] && p.charAt(j-1)=='*')
                    match[i][j] = true;
            }
        }
        
        return match[s.length()][p.length()];
    }

	
	//DP solution
    public static boolean isMatch(String s, String p) {
    	if(p.replace("*", "").length() > s.length()){
    		return false;
    	}
    	
    	boolean[] d = new boolean[s.length() + 1];
    	
    	d[0] = true;
    	for(int i = 1; i < s.length(); i++){
    		d[i] = false;
    	}
    	
    	for(int i = 1; i <= p.length(); i++){
    		char pchar = p.charAt(i - 1);
    		
    		if(pchar == '*'){
    			for(int j = 1; j <= s.length(); j++){
    				d[j] = d[j - 1] || d[j];
    			}
    		}else{
    			for(int j = s.length(); j >= 1; j--){
    				d[j] = d[j - 1] && (pchar == '?' || pchar == s.charAt(j - 1));
    			}
    		}
    		
    		d[0] = d[0] && pchar == '*';
    		
    	}

    	
    	return d[s.length()];
    
    }
    
    
    //worst m*n solution
    public static boolean isMatch2(String str, String pattern){
    	int s = 0, p = 0, match = 0, starIdx = -1;
    	while(s < str.length()){
    		
    		//advancing both pointers
    		if(p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
    			s++;
    			p++;
    		}
    		
    		//found *, only advance pattern pointer
    		else if(p < pattern.length() && pattern.charAt(p) == '*'){
    			starIdx = p;
    			match = s;
    			p++;
    		}
    		
    		//last pattern pointer is *, advance string pointer
    		else if(starIdx != -1){
    			p = starIdx + 1;
    			match++;
    			s = match;
    		}
    		
    		//characters do not match and previous pattern ppointer is not *
    		else return false;
    	}
    	
    	//check for remaining characters in pattern.
    	while(p < pattern.length() && pattern.charAt(p) == '*')
    		p++;
    	
    	return p == pattern.length();
    }


}
