/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
 * of rows like this: (you may want to display this pattern in a fixed font for 
 * better legibility)
 * P   A   H   N
   A P L S I I G
   Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author Lu
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String convert(String s, int numRows) {
        if(s == null || numRows < 2) return s;
        String[] buffer = new String[numRows];
        for(int i=0; i<numRows; i++){
            buffer[i] = "";
        }
        
        for(int i = 0; i < s.length(); i++){
            int index = i % (numRows * 2 - 2);
            if(index < numRows) buffer[index] += s.charAt(i);
            else{
                buffer[numRows * 2 - 2 - index] += s.charAt(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String st : buffer){
            sb.append(st);
        }
        return sb.toString();
    }


}
