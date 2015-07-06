/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author Lu
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
