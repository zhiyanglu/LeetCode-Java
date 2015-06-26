
public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	//find the leftmost common digits of m and n
	//O(log n) time complexity
	public int rangeBitwiseAnd(int m, int n) {
    	int mask = 0xffffffff;
    	while((m&mask) != (n&mask)){
    		mask <<= 1;
    	}
    	return mask&m;
    }
	
	//use math to compute the index of the highest common digit
    public int rangeBitwiseAnd2(int m, int n) {
        if (m == n){
            return m;
        }
        //The highest bit of 1 in diff is the highest changed bit.
        int diff = m ^ n;
        //Index is the index of the highest changed bit. Starting at 1.
        int index = (int)(Math.log(diff) / Math.log(2)) + 1;
        //Eliminate the changed part.
        m = m & (0xffffffff<<index);
        return m;
    }



}
