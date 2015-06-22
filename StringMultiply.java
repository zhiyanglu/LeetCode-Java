
public class StringMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("001001","00011"));
	}
	
    public static String multiply(String num1, String num2) {
    	int[] production = new int[num1.length() + num2.length()];
    	for(int i = num1.length() - 1; i >= 0; i--){
    		for(int j = num2.length() - 1; j >= 0; j--){
    			production[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
    		}
    	}
    	
    	String result = "";
    	int carry = 0;
    	StringBuilder bd = new StringBuilder();
    	for(int i = production.length - 1; i >= 0; i--){
    		int temp = (production[i] + carry) % 10;
    		carry = (production[i] + carry) / 10;
    		bd.insert(0, temp);
    	}
    	
    	for(int i = 0; i < bd.length(); i++){
    		
    		if(bd.charAt(i) == '0'){
    			bd.deleteCharAt(i);
    			i--;
    		}else{
    			break;
    		}
    	}
    	
        return bd.length() == 0 ? "0" : bd.toString();
    }


}
