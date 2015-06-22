import java.util.ArrayList;
import java.util.List;


public class TextJustification {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] letters = {"a", "b", "c", "d", "e"};
		String[] a = {""};
		List<String> result = fullJustify(a, 0);	
		for(String line : result){
			System.out.println(line + ' ' + line.length());
		}

	}
	
	
	//shoter solution
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        for(int linestart = 0, nextword; linestart < words.length; linestart = nextword){
        	int len = -1;
        	for(nextword = linestart; nextword < words.length && len + 1 + words[nextword].length() <= maxWidth; nextword++){
        		len += words[nextword].length() + 1;
        	}
        	
        	StringBuilder sb = new StringBuilder(words[linestart]);
        	int space = 1, extra = 0;
        	if(nextword != linestart + 1 && nextword != words.length){
        		space = (maxWidth - len) / (nextword - linestart - 1) + 1;
        		extra = (maxWidth - len) % (nextword - linestart - 1);
        	}
        	
        	for(int i = linestart + 1; i < nextword; i++){
        		for(int s = space; s > 0; s--) sb.append(' ');
        		if(extra-- > 0) sb.append(' ');
        		sb.append(words[i]);

        	}
        	
        	int strlen = maxWidth - sb.length();
        	while(strlen-- > 0) sb.append(' ');
        	list.add(sb.toString());    	
        }        

        return list;
    }
    
    
    //My solution
    public static List<String> fullJustify2(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        
        int index = 0;
        while(index < words.length){
        	int len = -1;
            List<String> temp = new ArrayList<String>();

        	while(index < words.length && len + words[index].length() + 1 <= maxWidth){
        		len += words[index].length() + 1;
        		temp.add(words[index]);
        		index++;
        	}
        	boolean lastline = index == words.length;
        	list.add(buildLine(temp, len, maxWidth, lastline));
        }
        return list;
    }
    
    public static String buildLine(List<String> list, int len, int maxWidth, boolean lastline){
    	
    	int space = 1;
    	int extra = 0;
    	
    	if(!lastline && list.size() > 1){
    		space = (maxWidth - len) / (list.size() - 1) + 1;
            extra = (maxWidth - len) % (list.size() - 1);    		    			
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < list.size(); i++){
    		if(i == 0) sb.append(list.get(i));
    		else{
    			for(int k = space; k > 0; k--) sb.append(' ');
    			if(extra-- > 0) sb.append(' ');
    			sb.append(list.get(i));
    		}
    	}
    	
    	int strlen = maxWidth - sb.length();
    	while(strlen-- > 0) sb.append(' ');
    	
    	return sb.toString();
    }


}
