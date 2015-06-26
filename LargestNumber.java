import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a list of non negative integers
 * arrange them such that they form the largest number.
 */
public class LargestNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	
	/*
	 * Sort the numbers according to the rlue:
	 * 1. If the length of two number is same, return bigger one 
	 * 2. If the length of two is not same, return the comparison
	 * 	  of ab and ba
	 */
    class StringComparator implements Comparator<String>{
    	public int compare(String a, String b){
    		if(a.length() == b.length()){
    			return b.compareTo(a);
    		}else{
    			String ab = a + b;
    			String ba = b + a;
    			return ba.compareTo(ab);
    		}
    	}
    }
	public String largestNumber(int[] nums) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < nums.length; i++){
			list.add(Integer.toString(nums[i]));
		}
		Collections.sort(list, new StringComparator());
		StringBuilder sb = new StringBuilder();
		for(String s : list){
			sb.append(s);
		}
		if(sb.length()==0 || sb.charAt(0)=='0') 
			return "0";
		else 
			return sb.toString();
    }
    
    

}
