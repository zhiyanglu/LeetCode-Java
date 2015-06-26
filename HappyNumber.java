import java.util.HashSet;
import java.util.Set;


public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Write an algorithm to determine 
	 * if a number is "happy".
	 */
	public boolean isHappy(int n){
		Set<Integer> set = new HashSet<Integer>();
		while(!set.contains(n)){
			set.add(n);
			int next = 0;
			while(n!=0){
				next += Math.pow(n%10, 2);
				n /= 10;
			}
			n = next;
		}
		return n == 1;
	}
	
	public boolean isHappy2(int n){
		if(n == 1) return true;
		Set<Integer> set = new HashSet<Integer>();
		while(!set.contains(n)){
			set.add(n);
			n = tryToDie(n);			
		}
		return n==1;
	}
	private int tryToDie(int n){
		int res = 0;
		while(n != 0){
			res += Math.pow(n%10, 2);
			n /= 10;
		}
		return res;
	}

}
