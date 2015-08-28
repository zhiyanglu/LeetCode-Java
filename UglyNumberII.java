/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * @author Lu
 *
 */
public class UglyNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UglyNumberII().nthUglyNumber(6));
	}
	
	/**
	 * DP solution
	 * @param n
	 * @return
	 */
    public int nthUglyNumber(int n) {
    	int[] seq = new int[n];
    	seq[0] = 1;
    	int index2 = 0, index3 = 0, index5 = 0;
    	
    	for(int i = 1; i < n; i++){
    		int min = Math.min(seq[index2]*2, Math.min(seq[index3]*3, seq[index5]*5));
    		seq[i] = min;
    		if(seq[index2]*2 == min){
    			index2++;
    		}
    		if(seq[index3]*3 == min){
    			index3++;
    		}
    		if(seq[index5]*5 == min){
    			index5++;
    		}
    	}
    	return seq[n-1];
    }


}
