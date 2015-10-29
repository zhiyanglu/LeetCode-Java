import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {

	public static void main(String[] args){
		String[] dictionary = {"dog"};
		ValidWordAbbr solution = new ValidWordAbbr(dictionary);
		
		String[] check = {"dig", "dug", "dag"};
		for(String word : check){
			System.out.println(solution.isUnique(word));
		}
	}
	
	
    Map<String, Integer> map;
    Set<String> dict;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, Integer>();
        dict = new HashSet<String>();
        for(String word : dictionary){
            if(dict.contains(word)) continue;
            dict.add(word);
            String abbr = shorten(word);
            if(map.containsKey(abbr)){
                map.put(abbr, map.get(abbr) + 1);
            }else{
                map.put(abbr, 1);
            }
        }
    }
    private String shorten(String word){
        if(word.length() <= 2) return word;
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        
        return sb.toString();
    }

    public boolean isUnique(String word) {
        String abbr = shorten(word);
        if(!map.containsKey(abbr)) return true;
        else if(map.containsKey(abbr) && map.get(abbr) == 1 && dict.contains(word)){
            return true;
        }else{
            return false;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");