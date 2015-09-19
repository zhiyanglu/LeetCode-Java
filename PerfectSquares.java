import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PerfectSquares().numSquares4(7168));
	}
	
	
	
	
	/**
	 * DP solution
	 * @param n
	 * @return
	 */
    public int numSquares1(int n) {
        int[] opt = new int[n+1];
        opt[0] = 0;
        
        for(int i = 1; i <= n; i++){
            opt[i] = i;
            for(int j = 1; j * j <= i; j++){
                opt[i] = Math.min(opt[i], opt[i-j*j] + 1);
            }
        }
        
        return opt[n];
    }
    
    /**
     * static DP solution
     * @param n
     * @return
     */
    static ArrayList<Integer> list = new ArrayList<Integer>();
	public int numSquares2(int n){
		if(list.size() == 0) list.add(0);
		for(int i = list.size(); i <= n; i++){
			list.add(i);
			for(int j = 1; j * j <= i; j++){
				list.set(i, Math.min(list.get(i), list.get(i - j*j) + 1));
			}
		}
		return list.get(n);
	}

    /**
     * Mathmatic solutoin
     * Based on Lagrange's Four Square theorem, there 
     * are only 4 possible results: 1, 2, 3, 4.
     * @param n
     * @return
     */
	public int numSquares3(int n){
		
		//return 1 if n is square
		if(isSquare(n)) return 1;
		
		// The result is 4 if n can be written in the 
        // form of 4^k*(8*m + 7).
		while(n % 4 == 0) n /= 4;
		if(n % 8 == 7) return 4;
		
		//check if the result is 2
		int sqrt = (int)Math.sqrt((double)n);
		for(int i = 0; i <= sqrt; i++){
			if(isSquare(n - i*i)) return 2;
		}
		
		return 3;
	}
    private boolean isSquare(int n){
    	int sqrt = (int)Math.sqrt((double)n);
    	return sqrt*sqrt == n;
    }
    
    /**
     * BFS solution
     */
    public int numSquares4(int n){
    	ArrayList<Integer> squares = new ArrayList();
    	Set<Integer> visited = new HashSet<Integer>();
    	for(int i = 1; i*i <= n; i++){
    		squares.add(i*i);
    	}
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	int level = 1;
    	q.add(n);
    	while(!q.isEmpty()){
    		int parent = q.poll();
    		visited.add(parent);
    		//a mark that we arrive the next level
    		if(parent == -1){
    			level++;
    			continue;
    		}
    		
    		if(isSquare(parent)) return level;
    		
    		q.add(-1);
    		for(int i = (int)Math.sqrt((double)n); i > 0; i--){
    			if(!visited.contains(i*i))
    				q.add(parent - i * i);
    		}
    		
    	}
    	
    	return -1;
    }

}
