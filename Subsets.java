import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};
		
		System.out.println(new Subsets().subsets(nums));
	}
	
    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> list;
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        res = new ArrayList();
        list = new ArrayList();
        Arrays.sort(nums);
        
        res.add((ArrayList<Integer>)list.clone());
        subsetsHelper(0, nums);
        
        return res;
    }
    
    private void subsetsHelper(int start, int[] nums){
        
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            res.add((ArrayList<Integer>)list.clone());
            subsetsHelper(i+1, nums);
            list.remove(list.size()-1);
        }
    }


}
