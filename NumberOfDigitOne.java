/**
 * Given an integer n, count the total number of digit 1 appearing 
 * in all non-negative integers less than or equal to n.
 * @author Lu
 *
 */
public class NumberOfDigitOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumberOfDigitOne().countDigitOne(316));
		
	}

	public int countDigitOne(int n){
		int ones = 0, multi = 1, remind = 1;
		while(n > 0){
			
			//if digit >= 2, use (n/10 + 1) to multiply
			//if digit == 1, use (n/10) to multiply and add remind
			//if digit == 0, use (n/10) to multiply
			ones += (n + 8) / 10 * multi + (n % 10 == 1 ? remind : 0);
			remind += n % 10 * multi;
			multi *= 10;
			n /= 10;
		}
		
		return ones;
	}
	
}
