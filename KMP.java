
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] next = new KMP().getNext("ABCDASBABCKDKAA");
//		for(Integer a : next){
//			System.out.print(a + " ");
//		}
		new KMP().getNext("aacecaaaaaacecaa");
		System.out.println(new KMP().match("ABCDASBABCKDKAA", "ABCKD"));
	}
	
	
	/**
	 * KMP algorithm
	 * return the index of p in s
	 * @param s: Original text
	 * @param p: Matching pattern
	 * @return index
	 * 
	 * 
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

}
