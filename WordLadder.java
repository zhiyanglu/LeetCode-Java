import java.util.LinkedList;
import java.util.Set;


public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcde";
		char[] t = s.toCharArray();
		t[3] = 'f';
		StringBuilder sb = new StringBuilder();
		sb.append(t);
		System.out.println(sb.toString());
	}
	
	
	/*
	 * Short BFS solution
	 * Using string concatenation may cause TLE
	 */	
    public int ladderLength(String start, String end, Set<String> dict) {
    	LinkedList<String> queue = new LinkedList<String>();
    	queue.add(start);
    	dict.add(end);
    	int step = 0;
    	
    	while (!queue.isEmpty()) {
    		LinkedList<String> level = new LinkedList<String>();
    		step++;
    		while (!queue.isEmpty()) {
    			String q = queue.poll();
    			if(q.equals(end))
    				return step;
    			
    			char[] t = q.toCharArray();
    			for(int i = 0; i < start.length(); i++){
    				for(char c = 'a'; c <= 'z'; c++){
    					char temp = t[i];
    					t[i] = c;
    					String s = String.copyValueOf(t);
                        t[i] = temp;
    					if(dict.contains(s)){
    						level.add(s);
    						dict.remove(s);
    					}
    				}
    			}
    		}
    		queue = level;
    	}
    	    	
    	return 0;
    }


}
