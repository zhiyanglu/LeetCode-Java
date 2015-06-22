
public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//Recursive solution
	public boolean isScramble(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		if(s1.length() == 0) return false;
		return isScramble(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
	}
	public boolean isScramble(String s1, String s2, int ss1, int es1, int ss2, int es2){
		//basic condition of 1 character
		if(ss1 == es1 && s1.charAt(ss1) == s2.charAt(ss2)) return true;
		int chars[]  = new int[256];
		for(int i = ss1; i <= es1; i++){	//put sub s1 to map;
			chars[s1.charAt(i)]++;
		}
		for(int i = ss2; i <= es2; i++){	//remove sub s2 from map;
			chars[s2.charAt(i)]--;
		}
		for(int i = 0; i < 256; i++){		//check if s1 has same chars as s2
			if(chars[i] != 0) return false;
		}
		
		for(int i = ss1; i < es1; i++){
			//check first n chars in s1 with last n chars in s2
			//check last n chars in s1 with first n chars in s1
			if(isScramble(s1, s2, ss1, i, es2 - i + ss1, es2)
			&& isScramble(s1, s2, i + 1, es1, ss2, es2 - i + ss1 - 1)) return true;

			//check first n chars in s1 with first n chars in s2
			//check last n chars in s1 with last n chars in s1			
			if(isScramble(s1, s2, ss1, i, ss2, ss2 + i - ss1) 
			&& isScramble(s1, s2, i + 1, es1, ss2 + i - ss1 + 1, es2)) return true;
		}
		
		return false;
		
	}
}
