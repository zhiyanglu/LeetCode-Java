import java.util.Arrays;
import java.util.BitSet;


public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitSet bs = new BitSet(10);
		bs.set(0);
		bs.set(1);
		System.out.println(bs.toString());
	}
	
	/*
	 * Use BitSet in Java to implement
	 */
	public int countPrimes(int n){
		BitSet bs = new BitSet(n);
		bs.set(0);
		bs.set(1);
		int ind = 0, count = 0;
		while(ind < n){
			ind = bs.nextClearBit(ind + 1);
			if(ind >= n)
				return count;
			count++;
			for(int i = 2 * ind; i < n; i+=ind)
				bs.set(i);
		}
		return count;
	}
	
	/*
	 * O(n log log n) complexity, O(n) space solution -- The Sieve of Eratosthenes
	 * Set up an array to indicate if i is prime
	 * for each i (i * i < n), set all numbers from i * i to n with step i to non-prime
	 */
	public int countPrimes2(int n ){
		if(n < 3) return 0;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		double sqr = Math.sqrt(n);
		for(int i = 2; i < sqr; i++){
			if(!isPrime[i]) continue;
			for(int j = i * i; j < n; j+=i){
				isPrime[j] = false;
			}
		}
		int count = 0;
		for(int i = 2; i < n; i++){
			if(isPrime[i]) count++;
		}
		return count;
	}
	
	/*
	 * O(nlogn) solution
	 */
	public int countPrimes3(int n){
		int count = 0;
		for(int i = 3; i < n; i++){
			if(isPrime(i)) count++;
		}
		return count;
	}
	private boolean isPrime(int n){
		for(int i = 2; i * i < n; i++){
			if(n%i == 0) return false;
		}
		return true;
	}

}
