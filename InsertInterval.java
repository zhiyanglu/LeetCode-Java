import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * @author Lu
 *
 */
public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval a = new Interval(1, 5);
		List<Interval> intervals = new ArrayList();
		intervals.add(a);
		Interval newInterval = new Interval(2, 3);
		new InsertInterval().insert2(intervals, newInterval);
		
	}
	
	
	/**
	 * O(n) solution without sorting
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
    	
    	if(intervals.size() == 0) intervals.add(newInterval);
    	else{
        	for(int i = 0; i < intervals.size(); i++){
        		if(newInterval.start < intervals.get(i).start){
        			intervals.add(i, newInterval);
        			break;
        		}
        		if(i == intervals.size()-1){
        			intervals.add(newInterval);
        			break;
        		}
        	}    		
    	}
    	
    	List<Interval> res = new ArrayList();
    	
    	Interval prev = null;
    	for(Interval inter : intervals){
    		if(prev == null){
    			prev = inter;
    			res.add(inter);
    		}else if(prev.end >= inter.start ){
    			prev.end = Math.max(prev.end, inter.end);
    		}else{
    			prev = inter;
    			res.add(inter);
    		}
    	}
    	
    	return res;
    }
	/**
	 * O(nlogn) solution
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	
    	intervals.add(newInterval);
    	Collections.sort(intervals, new Comparator<Interval>(){
    		public int compare(Interval o1, Interval o2){
    			return o1.start - o2.start;
    		}
    	});
    	
    	List<Interval> res = new ArrayList<Interval>();

    	Interval prev = null;
    	for(Interval interval : intervals){
    		if(prev == null){
    			res.add(interval);
    			prev = interval;
    		}else if(prev.end >= interval.start){
    			prev.end = Math.max(interval.end, prev.end);
    		}else{
    			res.add(interval);
    			prev = interval;
    		}
    	}
    	
    	return res;
    	
    }


}
