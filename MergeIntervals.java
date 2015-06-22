import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}

        });
        
        Interval prev = null;
        for(Interval inter : intervals){
        	if(prev == null){
        		prev = inter;
        		list.add(inter);
        	}else if(prev.end < inter.start){
        		prev = inter;
        		list.add(inter);
        	}else if(prev.end < inter.end){
        		prev.end = inter.end;
        	}
        }
        return list;
    }


}
