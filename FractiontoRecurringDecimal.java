import java.util.HashMap;
import java.util.Map;


public class FractiontoRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(1, 7));
	}
	
	/*
	 * Use a hash map to record the appeared remainder and its index
	 * if a remainder appears twice, insert ( to its first appeared index
	 */
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0) return "0";
		
		StringBuilder sb = new StringBuilder();
		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);

		sb.append(Long.toString(num/den));

		if (numerator % denominator == 0) {
			return sb.toString();
		}
		sb.append(".");

		Map<Long, Integer> map = new HashMap();
		long remain = num % den;
		while (remain != 0) {
			remain *= 10;
			if (!map.containsKey(remain)) {
				map.put(remain, sb.length()); 
				sb.append(remain / den);													
			} else {
				sb.insert(map.get(remain), "(");
				sb.append(')');
				break;
			}
			remain = remain % denominator;
		}
		return sb.toString();
	}

}
