
public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromePartitioningII().minCut2("abbab"));
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
    
    public int minCut2(String s) {
        // write your code here
        int len = s.length();
        boolean isPal[][] = new boolean[len][len];
        for(int i = 0; i < len; i++){
            isPal[i][i] = true;
        }
        int[] minCut = new int[len];
        
        for(int i = 0; i < len; i++){
            minCut[i] = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(j) == s.charAt(i) && (i - j <= 2 || isPal[j+1][i-1])){
                    if(j == 0){
                        minCut[i] = 0;
                    }else{
                        minCut[i] = Math.min(minCut[i], minCut[j-1] + 1);
                    }
                    isPal[j][i] = true;
                }
            }
            
        }
        
        return minCut[minCut.length - 1];
        
    }



}
