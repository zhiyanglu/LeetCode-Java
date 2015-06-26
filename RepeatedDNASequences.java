import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and 
 * T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to 
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * Tags: Bit Manipulation
 */
public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}
	
	/*
	 * A: 0x41, C: 0x43, G: 0x47, T: 0x54, last 3 bits are different
     * 10 chars, each 3 bits, 10 x 3 = 30 bits < 32
     * 
     * Key: an integer to record the bit mask of current substring, 
     * Value: a boolean, true means showed up before, false means already added
     * Update the map
     */
	public List<String> findRepeatedDnaSequences(String s){
		List<String> list = new ArrayList();
		if(s == null || s.length() < 10) return list;
		char[] c = s.toCharArray();
		Map<Integer, Boolean> map = new HashMap();
		for(int t = 0, i = 0; i < s.length(); i++){
			//use 30 bits to record the string
			//3 bits for each character
			//add new character hash to end of t
			t = (t << 3 & 0x3FFFFFFF) | (s.charAt(i) & 0x7);
			if(map.containsKey(t)){
				if(map.get(t)){
					list.add(String.copyValueOf(c, i-9, 10));
					map.put(t, false);
				}
			}else{
				map.put(t, true);
			}
		}
		return list;
	}
	
	/*
	 * Rolling Hash
	 */
	public List<String> findRepeatedDnaSequences2(String s){
		Map<Character, Integer> A = new HashMap();
		A.put('A', 0);
		A.put('C', 1);
		A.put('G', 2);
		A.put('T', 3);
		int A_SIZE_POW_9 = (int)Math.pow(A.size(), 9);
		
		Set<String> res = new HashSet<String>();
		Set<Integer> hashes = new HashSet<Integer>();
		for(int i = 0, rhash = 0; i < s.length(); i++){
			if(i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i - 10));
			rhash = A.size() * rhash + A.get(s.charAt(i));
			if(i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9, i+1));
		}
		
		return new ArrayList<>(res);
		
	}
	
	
	/*
	 * MLE
	 */
	public List<String> findRepeatedDnaSequences3(String s){
		Map<String, Integer> map = new HashMap();
		List<String> list = new ArrayList<String>();
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length - 10; i++){
			String seq = String.copyValueOf(c, i, 10);
			if(!map.containsKey(seq)){
				map.put(seq, 1);
			}else{
				if(map.get(seq) == 1){
					list.add(seq);
					map.put(seq, 2);
				}
			}
		}
		
		return list;
	}

}
