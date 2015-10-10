import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> list;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        Collections.sort(S);
        res = new ArrayList();
        list = new ArrayList();
        res.add((ArrayList<Integer>)list);
        subsetsHelper(0, S);
        
        return res;
    }
    private void subsetsHelper(int start, ArrayList<Integer> S){
        Set<Integer> used = new HashSet<Integer>();
        for(int i = start; i < S.size(); i++){
            if(used.contains(S.get(i))) continue;
            used.add(S.get(i));
            list.add(S.get(i));
            res.add((ArrayList<Integer>)list.clone());

            subsetsHelper(i+1, S);
            list.remove(list.size()-1);            
        }
    }


}
