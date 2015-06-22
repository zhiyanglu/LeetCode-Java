
public class DivideTwoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, 1));
	}
	
	public static int divide(int dividend, int divisor){
		int result = 0;

		if(dividend == -2147483648 && divisor == -1){
        	return Integer.MAX_VALUE;
        }
		
		int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
        
		long a = dividend;
        long b = divisor;
		long m = Math.abs(a);
        long n = Math.abs(b);
                
        if(n == 0 || m < n){
        	return 0;
        }
        
        while(m >= n){
            int count = 1;        	
            long current = n;

            while(current + current <= m){
            	current = current + current;
            	count = count + count;
            }
            
            m -= current;
            result += count;
        }
                
        if(sign > 0){
        	return result;
        }else{
        	return -result;
        }        
	}
}
