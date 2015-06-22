
public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("4e+"));

	}
	
    public static boolean isNumber(String s) {
    	
    	/*
    	 * A valid number:
    	 * 1. can contain only '+', '-', '.', 'e', each can only occur once
    	 * 2. '+' || '-' can only occur at first digit or after 'e'. Cannot be last digit;
    	 * 3. "*.*" one of '*' must be digit
    	 * 4. "*e*" left * must be valid number or '.', right * must be a digit
    	 * 5. right of e cannot contain '.'
    	 */
    	
    	s = s.trim();
    	if(s.length() == 0) return false;
    	
    	int deci = -1;
    	int e = -1;
    	
    	for(int i = 0; i < s.length(); i++){
    		
    		char d = s.charAt(i);
    		
    		if(Character.isDigit(d)){
    			continue;
    		}else if(d == '+' && i == e + 1 && i != s.length() - 1){
    			continue;
    		}else if(d == '-' && i == e + 1 && i != s.length() - 1){
    			continue;
    		}else if(d == '.' && deci == -1){
    			deci = i;
    		}else if(d == 'e' && e == -1){
    			e = i;
    		}else{
    			return false;
    		} 		
    	}
    	
    	char left = ' ';
    	char right = ' ';
    	
    	if(e != -1 && deci > e) return false;

    	if(deci != -1){
        	if(deci > 0) left = s.charAt(deci - 1);
        	if(deci < s.length() - 1) right = s.charAt(deci + 1);
        	if(!Character.isDigit(left) && !Character.isDigit(right)){
        		return false;
        	}    		
    	}
    	
    	if(e != -1){
        	left = ' ';
        	right = ' ';
        	if(e > 0) left = s.charAt(e - 1);
        	if(e < s.length() - 1) right = s.charAt(e + 1);
        	if(!((Character.isDigit(left) || left == '.') && (Character.isDigit(right) || right == '+' || right == '-'))){
        		return false;
        	}    		
    	}
    	
    	return true;
    }
}
