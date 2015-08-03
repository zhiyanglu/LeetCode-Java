/**
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        
        for(Integer x : map){
            if(x != 0) return false;
        }
        return true;
    }

}
