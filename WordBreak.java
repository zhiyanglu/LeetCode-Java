import java.util.Set;


public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordBreak(String s, Set<String> dict){
		if(dict.contains(s)) return true;
		
		boolean[] A = new boolean[s.length() + 1];
		A[0] = true;
		for(int i = 1; i < s.length() + 1; i++){
			for(int j = i - 1; j >= 0; j--){
				if(A[j] && dict.contains(s.substring(j, i))){
					A[i] = true;
					break;
				}
			}
		}
		
		return A[s.length()];
	}

}
