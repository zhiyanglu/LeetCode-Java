/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * @author Lu
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MultiplyStrings().multiply("9", "9"));
	}
	
    public String multiply(String num1, String num2) {
    	
    	if(num1==null || num2==null || num1.equals("0") || num2.equals("0")) return "0";
    	
    	int[] sum = new int[num1.length() + num2.length()];
    	for(int i = num1.length()-1; i >=0; i--){
    		for(int j = num2.length()-1; j>=0; j--){
    			sum[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j) -'0');
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = sum.length-1; i>=0; i--){
    		int bit = sum[i] % 10;
    		sb.insert(0, bit);
    		if(i>0)
    			sum[i-1] += sum[i]/10;
    	}
    	
    	while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
    	
    	return sb.length() == 0 ? "0" : sb.toString();
    	
    }

}
