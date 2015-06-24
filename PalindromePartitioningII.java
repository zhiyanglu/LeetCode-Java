
public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromePartitioningII().minCut("abbac"));
	}
	
	
	/*
	 * O(n^2) DP solution, O(n^2) space
	 */
    public int minCut(String s) {
    	if(s == null || s.length() == 0) return 0;
    	int len = s.length();
    	
    	//cut[i] record the min cut for i to n
    	int[] cut = new int[len];
    	
        //par[i][j] indicate if i to j is Palindrome
    	boolean[][] isPal = new boolean[len][len];
    	
    	for(int i = len - 1; i >= 0; i-- ){
    		cut[i] = len - i - 1;
    		for(int j = i; j < len; j++){
    			if((s.charAt(i) == s.charAt(j)) && (j - i < 2 || isPal[i+1][j-1])){
    				isPal[i][j] = true;
    				if(j == len - 1){
    					cut[i] = 0;
    				}else{
    					cut[i] = Math.min(cut[i], cut[j+1]+1);
    				}
    			}
    		}
    	}
    	
    	return cut[0];
    }


}
