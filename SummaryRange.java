import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author Lu
 *
 */
public class SummaryRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4,5,7};
		System.out.println(new SummaryRange().summaryRanges(nums));

	}
	
    public List<String> summaryRanges(int[] nums) {
    	
    	List<String> result = new ArrayList<String>();
    	for(int i = 0; i < nums.length; i++){
    		StringBuilder sb = new StringBuilder();
    		int start = nums[i];
    		sb.append(start);
    		while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1){
    			i++;
    		}
    		if(start != nums[i]){
    			sb.append("->");
    			sb.append(nums[i]);
    		}
    		result.add(sb.toString());
    	}
    	return result;
    }


}
