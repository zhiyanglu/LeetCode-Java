import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive 
 * values differ in only one bit.
 * Given a non-negative integer n representing the total number 
 * of bits in the code, print the sequence of gray code. A gray 
 * code sequence must begin with 0.
 * @author Lu
 *
 */
public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Solution based on fomulation G(i) = i ^ i/2
	 * @param n
	 * @return
	 */
    public List<Integer> grayCode(int n) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	for(int i=0; i < 1<<n; i++){
    		list.add(i ^ (i>>1));
    	}
    	
    	return list;
    }

}
