/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there 
 * exists one unique longest palindromic substring.
 * @author Lu
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	

	
	/**
	 * O(n^2) solution
	 * traverse the string and find the longest palindrome for each pivot
	 */
    int start;
    int end;
    public String longestPalindrome(String s) {
        start = 0;
        end = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            findPalindrome(chars, i, 1);
            findPalindrome(chars, i, 0);
        }
        return s.substring(start, end+1);
    }
    private void findPalindrome(char[] chars, int i, int shift){
        int left = i;
        int right = i+shift;
        while(left >=0 && right < chars.length && chars[left] == chars[right]){
            if((right-left)>(end-start)){
                start = left;
                end = right;
            }
            left--;
            right++;
        }
    }

	
	/**
	 * O(n^3) solution
	 */
    public String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        while(len > 0){
            for(int i = 0; i < chars.length - len + 1; i++){
                if(isPalindrome(chars, i, i + len - 1)) return s.substring(i, i + len);
            }
            len --;
        }
        return "";
    }
    private boolean isPalindrome(char[] chars, int left, int right){
        for(; left < right; left++, right--)
            if(chars[left] != chars[right]) return false;
        return true;
    }


}
