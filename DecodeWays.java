
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DecodeWays().numDecodings("1"));
	}
	
	
	
	/*
	 * if the last char of the String is '0'. 
	 * it means there is no way to use it alone as a code. 
	 * it has to be a part of another code. 
	 * If the last char is not '0', let's say it's '5', 
	 * the there is 1 way to use this number as a code
	 */
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        
        int[] m = new int[n + 1];
        m[n] = 1;
        m[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; i--){
        	if(s.charAt(i) == '0') continue;
        	else{
        		m[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? m[i + 1] + m[i + 2] : m[i + 1];
        	}
        }
        
        return m[0];
    }


}
