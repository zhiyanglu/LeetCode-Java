import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

	}

    Map<Character, String> map;
    List<String> list;
    public List<String> letterCombinations(String digits) {
        map = new HashMap();
        list = new ArrayList();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuilder sb = new StringBuilder();
        findCombinations(digits, 0, sb);
        return list;
    }
    private void findCombinations(String digits, int index, StringBuilder sb){
        if(index == digits.length()){
            if(sb.length()>0)
                list.add(sb.toString());
            return;
        }
        
        String pattern = map.get(digits.charAt(index));
        for(int i = 0; i < pattern.length(); i++){
            sb.append(pattern.charAt(i));
            findCombinations(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }

}
