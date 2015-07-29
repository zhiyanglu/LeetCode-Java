/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public int reverse(int x) {
        if(x > 0) return reversePositive(x);
        else return -reversePositive(-x);
    }
    private int reversePositive(int x){
        int result = 0;
        while(x > 0){
            int bit = x % 10;
            x = x / 10;
            if(result < 0 || result > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + bit;
        }
        return result;
    }


}
