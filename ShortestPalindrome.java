/**
 * Given a string S, you are allowed to convert 
 * it to a palindrome by adding characters in 
 * front of it. Find and return the shortest 
 * palindrome you can find by performing this 
 * transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * @author Lu
 *
 */
public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
	}
	
	
	/**
	 * Solution based on KMP prefix computing.
	 * 1. Append mirror of s to the end of s
	 * 2. Calculate the prefix array of new string
	 * 3. Add s.length - (prefix[2*s.length - 1]+1) of
	 *    tail chars in s to the front of s.
	 *    
	 * http://blog.csdn.net/pointbreak1/article/details/45931551
	 * @param s
	 * @return
	 */
	public String shortestPalindrome(String s){
		if(s.length() == 0) return s;
		String result = "";
		String mirror = s + new StringBuilder(s).reverse().toString();
		int[] prefix = new int[mirror.length()];

		prefix[0] = -1;
		int k = -1, i = 0;
		while(i < mirror.length() - 1){
			if(k == -1 || mirror.charAt(k) == mirror.charAt(i)){
				k++;
				i++;
				prefix[i] = k;
			}else{
				k = prefix[k];
			}
		}

		int count = s.length() - prefix[prefix.length - 1] - 1;
		String front = s.substring(s.length() - count, s.length());
		result = new StringBuilder(front).reverse().toString() + s;
		return result;
	}
	
	
	
	/**
	 * TLE solution
	 * @param s
	 * @return
	 */
    public String shortestPalindrome2(String s) {
        int len = s.length();
        String inverse = new StringBuilder(s).reverse().toString();
        if(inverse.equals(s)) return s;
        
        for(int i = len; i >= 0; i--){
        	if(s.substring(0, i).equals(inverse.substring(len - i))){
        		return inverse.substring(0, len - i) + s;
        	}
        }
        return "";
    }


}
