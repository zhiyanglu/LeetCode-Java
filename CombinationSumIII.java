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
		System.out.println(new CombinationSumIII().combinationSum3(3, 9));
	}
	
	
	
	
	List<List<Integer>> result;
	List<Integer> list;
    /**
     * Accepted backtracking solution
     * @param k
     * @param n
     * @return
     */
	public List<List<Integer>> combinationSum3(int k, int n) {
    	
    	result = new ArrayList<List<Integer>>();
        list = new ArrayList<Integer>();
        if(k == 0) return result;
        for(int i = 1; i <= 9; i++ ){
        	list.add(i);
        	findSum(i, i+1, 1, k, n);
        	list.remove(list.size() - 1);
        }
        return result;
    }
    private void findSum(int sum, int start, int index, int k, int target){
    	if(sum == target && index == k){
    		result.add(new ArrayList<Integer>(list));
    		return;
    	}else if(!(sum < target && index < k)){
    		return;
    	}
    	
    	int end = Math.min(9, target - sum);
    	for(int i = start; i <= end; i++){
    		list.add(i);
    		findSum(sum + i, i + 1, index+1, k, target);
    		list.remove(list.size() - 1);
    	}
    }

}
