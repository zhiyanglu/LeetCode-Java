import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.swing.border.MatteBorder;


public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("-2147483647"));
	
	}
	
    public static int largestRectangleArea2(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        Stack<Integer> index = new Stack<Integer>();
        int max = 0;
        
        for(int i = 0; i < h.length; i++){
            if(index.isEmpty() || h[index.peek()] <= h[i]){
                index.push(i);
            }else{
                while(!index.isEmpty() && h[index.peek()] >= h[i]){
                    int top = h[index.pop()];
                    max = Math.max(max, index.isEmpty() ? top * i : top * (i - index.peek() - 1));
                }
                index.push(i);
            }
        }
        
        
        return max;
    }
    
    public static int myAtoi(String str) {
        if(str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        int sign = 1;
        int result = 0;
        while(chars[i] == ' ') i++;
        if (chars[i] == '-' || chars[i] == '+') {
            sign = chars[i] == '+' ? 1 : -1;
            i++;
        }
        
        while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && chars[i] > 7)){
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }        
            
            result = result * 10 + (chars[i] - '0');
            i++;
        }
        
        return result * sign;
   }


	
	public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                System.out.println(maxArea + " " + h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
	
    public static String addBinary(String a, String b) {
        int flow = 0;
        int nextbit;
        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        String result = "";
        
        while(a_index >= 0 || b_index >= 0 && flow > 0){
            nextbit = flow;
            if(a_index >= 0){
                nextbit += (int)(a.charAt(a_index) - '0');
                a_index--;
            }
            if(b_index >= 0){
                nextbit += (int)(b.charAt(b_index) - '0');
                b_index--;
            }
            if(nextbit > 1){
                flow = 1;
                nextbit -= 2;
            }
            System.out.println(nextbit);
            result = nextbit + result;
        }
        
        return result;

    }

	
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode insert_pos = head;
        ListNode insert_pos_prev = start;
        ListNode node;
        while(insert_pos != null){
            //make sure that there are k - 1 nodes after insert_pos;
            ListNode check = insert_pos;
            for(int i = 0; i < k - 1 && check != null; i++){
                check = check.next;
            }
            if(check == null){
                break;
            }
            
            for(int i= 0; i < k - 1; i++){
                node = insert_pos.next;
                insert_pos.next = node.next;
                node.next = insert_pos_prev.next;
                insert_pos_prev.next = node;
            }
            insert_pos_prev = insert_pos;
            insert_pos = insert_pos.next;
        }
        
        return start.next;
    }

	
	
	
    public static int numDistinct(String S, String T) {
        int[][] num = new int[T.length()+1][S.length()+1];
        for(int i = 0; i < num[0].length; i++){
            num[0][i] = 1;
        }
        for(int i = 1; i < num.length; i++){
            num[i][0] = 0;
        }
        
        for(int i = 1; i < num.length; i++){
            for(int j = 1; j < num[0].length; j++){
                if(S.charAt(j-1) == T.charAt(i-1)){
                    num[i][j] = num[i][j - 1] + num[i - 1][j - 1];
                }else{
                    num[i][j] = num[i][j - 1];
                }
            }
        }
        int[] a = new int[12];
        return num[T.length()][S.length()];
    }


}
