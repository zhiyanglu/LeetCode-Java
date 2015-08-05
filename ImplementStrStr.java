/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author Lu
 *
 */
public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Use KMP algorithm to implement strStr()
	 * @param s
	 * @param p
	 * @return
	 */
	public int match(String s, String p){
		int i = 0;
		int j = 0;
		int sLen = s.length();
		int pLen = p.length();
		
		int[] next = getNext(p);
		
		while(i < sLen && j < pLen){
			if(j == -1 || s.charAt(i) == p.charAt(j)){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		
		if(j == pLen){		//matching success
			return i - j;
		}else{
			return -1;
		}
	}
	//Optimized getNext function
	private int[] getNext(String p){
		int[] next = new int[p.length()];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < p.length() - 1){
			if(k == -1 || p.charAt(j) == p.charAt(k)){
				k++;
				j++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
		return next;
	}

	
	
	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        int len = needle.length();
        
        for(int i = 0; i < haystack.length()-len+1; i++){
            if(haystack.substring(i, i+len).equals(needle)) return i;
        }
        return -1;
    }


}
