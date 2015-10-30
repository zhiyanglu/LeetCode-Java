import java.util.ArrayList;
import java.util.List;


public class PalindromePermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    List<String> res;
    List<String> list;
    public List<String> generatePalindromes(String s) {
        res = new ArrayList<String>();
        list = new ArrayList<String>();
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c]++;
        }
        char single = 'a';
        boolean hasSingle = false;
        int len = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] % 2 == 1){
                if(hasSingle){
                    return res;
                }else{
                    single = (char)i;
                    hasSingle = true;
                }
            }
            count[i] /= 2;
            len += count[i];
        }
        
        StringBuilder sb = new StringBuilder();
        build(count, sb, len);
        
        for(String left : list){
            StringBuilder right = new StringBuilder();
            right.append(left);
            if(hasSingle) right.append(single);
            right.reverse();
            res.add(left + right.toString());
        }
        
        return res;
    }
    private void build(int[] count, StringBuilder sb, int len){
        if(sb.length() == len){
            list.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0){
                count[i]--;
                char c = (char)i;
                sb.append(c);
                build(count, sb, len);
                sb.deleteCharAt(sb.length() - 1);
                count[i]++;
            }
        }
    }
    


}
