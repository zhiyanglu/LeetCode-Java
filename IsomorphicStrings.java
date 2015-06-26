import java.util.HashMap;
import java.util.Map;


/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while 
 * preserving the order of characters. No two characters may map to the same 
 * character but a character may map to itself.
 * @author Lu
 *
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings test = new IsomorphicStrings();
		System.out.println(test.isIsomorphic("aa", "bb"));

	}
	
	/*
	 * Use a Map to record matching and an array to 
	 * record if char in t is used
	 */
	public boolean isIsomorphic(String s, String t){
		if(s.length() != t.length()) return false;
		int n = s.length();
		int[] map = new int[256];
		boolean[] used = new boolean[256];
		for(int i = 0; i < n; i++){
			if(!used[t.charAt(i)]){
				if(map[s.charAt(i)] != 0) return false;
				map[s.charAt(i)] = t.charAt(i);
				used[t.charAt(i)] = true;
			}else{
				if(map[s.charAt(i)] != t.charAt(i)) return false;
			}
		}
		return true;
	}
	
	
	
	/*
	 * Use pair matching
	 */
	public boolean isIsomorphic2(String s, String t){
		if(s.length() != t.length()) return false;
		int n = s.length();
		int[] s_match = new int[256];
		int[] t_match = new int[256];
		for(int i = 0; i < n; i++){
			if(s_match[s.charAt(i)] != t_match[t.charAt(i)]) return false;
			s_match[s.charAt(i)] = i+1;
			t_match[t.charAt(i)] = i+1;
		}
		return true;
	}

}
