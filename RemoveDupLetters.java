import java.util.HashMap;
import java.util.Map;


public class RemoveDupLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDupLetters solution = new RemoveDupLetters();
		String s = "abacb";
		System.out.println(solution.removeDuplicateLetters(s));

	}

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = getRight(map);
        while(map.size() > 0){
            char min = s.charAt(start);
            int min_index = start;
            for(int i = start; i <= end; i++){
            	if(!map.containsKey(s.charAt(i))){
            		continue;
            	}
                if(s.charAt(i) < min || !map.containsKey(min)){
                    min = s.charAt(i);
                    min_index = i;
                }
            }
            map.remove(min);
            sb.append(min);
            start = min_index + 1;
            end = getRight(map);
        }
        
        return sb.toString();
    }
    
    public int getRight(Map<Character, Integer> map){
        int end = Integer.MAX_VALUE;
        for(Character c : map.keySet()){
            end = Math.min(end, map.get(c));
        }
        return end;
    }
}
