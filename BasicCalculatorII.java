/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / 
 * operators and empty spaces . The integer division should truncate 
 * toward zero.You may assume that the given expression is always valid.
 * @author Lu
 *
 */
public class BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BasicCalculatorII().calculate("42"));
	}

    public int calculate(String s) {
    	int result = 0;
    	int number = 0;
    	int sign = 1;
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		
    		if(c == ' ') continue;
    		
    		if(c == '+'){
    			result += number * sign;
    			sign = 1;
    			number = 0;
    		}else if(c == '-'){
    			result += number * sign;
    			number = 0;
    			sign = -1;
    		}else if(c == '*'){
    			int mul = 0;
    			
    			while(i + 1 < s.length() && (Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == ' ')){
    				if(s.charAt(i + 1) == ' '){
    					i++;
    					continue;
    				}
    				mul = mul * 10 + s.charAt(i + 1) - '0';
    				i++;
    			}
    			number = number * mul;
    		}else if(c == '/'){
    			int div = 0;
    			while(i + 1 < s.length() && (Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == ' ')){
    				if(s.charAt(i + 1) == ' '){
    					i++;
    					continue;
    				}
    				div = div * 10 + s.charAt(i + 1) - '0';
    				i++;
    			}
    			number = number / div;
    		}else if(Character.isDigit(c)){
    			number = s.charAt(i) - '0';
    			while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
    				number = number * 10 + s.charAt(i + 1) - '0';
    				i++;
    			}
    		}
    	}
		if(number != 0) result += number * sign;
		return result;
    }
}
