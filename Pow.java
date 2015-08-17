/**
 * Implement pow(x, n).
 * Binary Search
 * @author Lu
 *
 */
public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	
    public double myPow(double x, int n) {
    	if(n == 0) return 1;
    	if(n % 2 == 0)
        	return myPow(x*x, n/2);
        
    	if(n > 0)
        	return myPow(x*x, n/2) * x;
    	else
    		return myPow(x*x, n/2) / x;
    }
    

}
