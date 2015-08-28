/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * @author Lu
 *
 */
public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int addDigits(int num) {
    	
    	return num == 0 ? 0 : 1+(num-1)%9;
    	
    }

}
