import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers 
 * that add up to a number n, given that only 
 * numbers from 1 to 9 can be used and each 
 * combination should be a unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted 
 * in ascending order.
 * 
 * Example:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * 
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * @author Lu
 *
 */
public class CombinationSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CombinationSumIII().combinationSum3(2, 18));
	}
	
	
    List<List<Integer>> res;
    List<Integer> list;
    /**
     * Backtracking solution
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList();
        list = new ArrayList();
        combinationSum3(k, n, 1);
        return res;
    }
    public void combinationSum3(int k, int n, int index){
        if(k <= 0 || n <= 0){
            if(k == 0 && n == 0) res.add(new ArrayList(list));
            return;
        }
        
        for(int i = index; i < 10; i++){
            list.add(i);
            combinationSum3(k-1, n-i, i+1);
            list.remove(list.size()-1);
        }
    }
}
