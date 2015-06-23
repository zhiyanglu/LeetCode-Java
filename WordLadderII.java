import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		for(List<String> list : new WordLadderII().findLadders("hit", "cog", dict)){
			for(String word : list){
				System.out.print(word + " ");
			}
			System.out.println();
		}
		
	}
	
	Map<String, List<String>> map;
	List<List<String>> results;
	
	
	// Use BFS Dijsktra to construct the backtrace map 
	// and use Backtracing to form the results
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        results = new ArrayList();
        if(dict.size() == 0) return results;
        
        
        //a map contains the word and its backtracks
        map = new HashMap<String, List<String>>();
        
        //a map record the minPath from start to each word in dict
        if(!dict.contains(end)) dict.add(end);
        Map<String, Integer> minPath = new HashMap();
        for(String word : dict){
        	minPath.put(word, Integer.MAX_VALUE);
        }
        minPath.put(start, 0);
        
        //current search level        
        LinkedList<String> queue = new LinkedList();
        queue.add(start);
        
        //record the min length from start to end
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
        	String word = queue.poll();
        	int step = minPath.get(word) + 1;
        	
        	if(step > min) break;
        	
        	for(int i = 0; i < start.length(); i++){
        		StringBuilder sb = new StringBuilder(word);
        		for(char c = 'a'; c <= 'z'; c++){
        			sb.setCharAt(i, c);
        			String new_word =  sb.toString();
        			
        			
        			if(minPath.containsKey(new_word)){ //the new word is in dict
        				if(step < minPath.get(new_word)){
        					minPath.put(new_word, step); 	//update the minPath
        					queue.add(new_word);		//put new word to search queue
        				}else if(step > minPath.get(new_word)){
        					continue;
        				}else ;				//important, dont continue here 
        									//cause the new_word can be formed by different word
        				
        				
        				//update the backtrack map
        				if(map.containsKey(new_word)){
        					map.get(new_word).add(word);
        				}else{
        					LinkedList<String> list = new LinkedList();
        					list.add(word);
        					map.put(new_word, list);
        				}
        				
        				if(new_word.equals(end)){
        					min = step;
        				}
        			}
        		}
        	}        	        	
        }
        
        //BackTrace to get result
        backTrace(end, start, new ArrayList<String>());
        
        return results;
    }
    
    private void backTrace(String word, String start, List<String> list){
    	if(word.equals(start)){
    		list.add(0, word);
    		results.add(new ArrayList<String>(list));
    		list.remove(0);
    		return;
    	}
    	
    	list.add(0, word);
    	if(map.get(word) != null){
    		for(String s : map.get(word)){
    			backTrace(s, start, list);
    		}
    	}
    	list.remove(0);
    }
}
