import java.util.ArrayList;
import java.util.List;


public class EncodeAndDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "};
		List<String> strs = new ArrayList();
		for(int i = 0; i < str.length; i++){
			strs.add(str[i]);
		}
		
		String code = new EncodeAndDecodeStrings().encode(strs);
		System.out.println(code);
		System.out.println(new EncodeAndDecodeStrings().decode(code));

	}
	public static int put(){
		return 1;
	}
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int n = s.length();
            sb.append(n);
            sb.append('/');
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                sb.append(encodeChar(c));
            }
        }
        
        return sb.toString();
    }
    
    private char encodeChar(char c){
        return (char)(((int)c + (int)'!') % 256);
    }
    private char decodeChar(char c){
        return (char)(((int)c - (int)'!' + 256) % 256);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; ){
        	String size = "";
        	while(Character.isDigit(chars[i])){
        		size += chars[i];
        		i++;
        	}
        	int len = Integer.parseInt(size);
            StringBuilder sb = new StringBuilder();
            for(int j = i + 1; j < i + len + 1; j++){
                sb.append(decodeChar(chars[j]));
            }
            res.add(sb.toString());
            i += len + 1;
        }
        
        return res;
    }

}
