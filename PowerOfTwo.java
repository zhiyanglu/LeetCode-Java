/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author Lu
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * if n is power of 2
	 * n&(n-1) should be 0
	 * @param n
	 * @return
	 */
    public boolean isPowerOfTwo2(int n) {
        if(n <= 0) return false;
        if((n & (n-1)) == 0) return true;
        else return false;
    }

	
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        boolean bitset = false;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                if(bitset) return false;
                else bitset = true;
            }
            n = n >> 1;
        }
        if(bitset) return true;
        else return false;
    }


}
