/**
 * Implement atoi to convert a string to an integer.
 * 
 * Examples:
 * "  -1a!s" 	-1
 * "  -+234" 	0
 * "+234abc"	234
 *
 */
public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringToInteger().myAtoi("-2147483647"));

	}
	
    public int myAtoi(String str) {
        int sign = 1;
        int number = 0;
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') i++;
        if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')){
            sign = str.charAt(i)=='+' ? 1 : -1;
            i++;
        } 
        for(; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                if(number < 0 || number > Integer.MAX_VALUE/10){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                number = number * 10 + (c - '0');
            }else{
                break;
            }
        }
        if(number < 0){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return number*sign;
    }


}
