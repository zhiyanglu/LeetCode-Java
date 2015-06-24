import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	List<List<String>> result = new ArrayList<List<String>>();
    List<Integer> split = new ArrayList<Integer>();
	
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        partition(chars, 0);
        return result;
        
    }
    
    private void partition(char[] chars, int index){
        int length = chars.length;
        if(index == length){
            List<String> list = new ArrayList<String>();
            int left = 0;
            for(int right : split){
                list.add(new String(chars, left, right - left));
                left = right;
            }
            
            result.add(list);
        }
        
        for(int i = index; i < length; i++){
            
            //see if i to index is a palindrome
            int left = index;
            int right = i;
            while(left < right){
                if(chars[left] != chars[right]) break;
                left++;
                right--;
            }
            
            if(left >= right){
                split.add(i + 1);
                partition(chars, i + 1);
                split.remove(split.size() - 1);
            }
            
        }
        
        
    }


}
