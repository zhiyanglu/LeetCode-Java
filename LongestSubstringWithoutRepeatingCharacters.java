import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating 
 * characters. For example, the longest substring without repeating letters 
 * for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest 
 * substring is "b", with the length of 1.
 * @author Lu
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                max = Math.max(i - start, max);
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c,i);

        }
        return Math.max(s.length()-start, max);
    }


}
