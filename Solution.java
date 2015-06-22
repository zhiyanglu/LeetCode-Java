import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;




public class Solution {
    
	public static void main(String[] args){
		/*
		int[] a = {1, 2 , 1, 2, 3, 4, 4, 3, 5};
		int singleNumber = singleNumber(a);
		System.out.println(singleNumber);

		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(1);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(1);
		System.out.println(maxDepth(root1));
		
		System.out.println(isSameTree(root1, root2));
		*/

		/*
		System.out.println(titleToNumber("AB"));
		int []a = {3, 2, 3, 4, 3, 4, 2, 1};
		mymaxProfit(a);
		*/
		
		//System.out.println(numTrees(4));
		//System.out.println(intToRoman(900));
		
		//int[][] grid = {{7, 2}, {6, 6}, {8, 6}, {8, 7}, {5, 0}, {6, 0}};
		//System.out.println(minPathSum(grid));
		
		/*
		int[] a = {1, 2, 3 , 4};
		ArrayList<ArrayList<Integer>> list = combine(4, 3);
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).size(); j++){
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		*/
		
		TreeNode a = new TreeNode(0);
		a.left = new TreeNode(1);
		System.out.println(sumNumbers(a));
		System.out.println(sumNumbers(a));
	}
	
	/*
	 * 136.Single Number
	 */
	public static int singleNumber(int[] A) {
        int a = 0;
        for(int i = 0; i < A.length; i++){
            a = a ^ A[i];
        }
        return a;
    }
	
	/*
	 * 104.Maximum Depth of Binary tree
	 */
	public static int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
	    int left = maxDepth(root.left);
	    int right = maxDepth(root.right);
	    return left > right ? left + 1 : right + 1;
	}
	
	/*
	 * 100.Same Tree
	 */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(q == null && p == null)
                return true;
            else
                return false;
        }
        
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
        	return false;
        }
    }
    
    
    /*
     * 171.Excel Sheet Column Number
     */
    public static int titleToNumber(String s) {
        int len = s.length();
        int i = 0;
        int result = 0;
        while(len > 0){
            result = (int)(result + ((int)s.charAt(len - 1) -  64) * Math.pow(26, i));
            i++;
            len--;
        }
    
        return result;
    }
    
    public static int mymaxProfit(int[] prices) {
        double profit = 1;
        boolean sold = true;
        int len =  prices.length;
        if(len == 1){
            return 0;
        }
        for(int i = 0; i < len; i++){
            if(i == 0){                             //first day condition
                if(prices[i] >= prices[i + 1]){
                    //do nothing
                }else{
                	System.out.println("Buy in day " + (i+1));
                    profit = profit / prices[i];
                    sold = false;
                }
            }else if(i == len - 1){                 //last day condition
                if(prices[i] > prices[i - 1]){
                    profit = profit * prices[i];
                    sold = true;
                	System.out.println("Sell in day " + (i+1));
                }else if(prices[i] < prices[i -1]){
                    //do nothing
                }else if(!sold){
                    profit = profit * prices[i];
                    sold = true;
                	System.out.println("Sell in day " + (i+1));
                }else{
                    //do nothing
                }
            }else if(sold && prices[i-1] > prices[i] && prices[i] <= prices[i+1]){  //day to buy
                sold = false;
            	System.out.println("Buy in day " + (i+1));
                profit = profit / prices[i];
            }else if(!sold && prices[i-1] <= prices[i] && prices[i] > prices[i+1]){ //day to sell
                sold = true;
            	System.out.println("Sell in day " + (i+1));
                profit = profit * prices[i];
            }else{
                //do nothing
            }
        }
        
        return (int)profit;
    }
    
    /*
     * 122.Best Time to But and Sell Stock II
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length - 1;

        while(len > 0){
            if(prices[len] > prices[len - 1])
                profit += (prices[len] - prices[len -1]);
            len--;
        }
        
        return profit;
    }
    
    /*
     * 96.Unique BST
     */
    public static int numTrees(int n) {
    	int[] catlan = new int[n+1];
    	if(n < 2){
            return 1;
        }
        catlan[0] = 1;
        catlan[1] = 1;
        for(int i = 2; i <= n; i++){
            catlan[i] = 0;
            for(int j = 0; j <= i - 1; j++){
                catlan[i] += catlan[j] * catlan[i - 1 - j];
            }
        }
        
        return catlan[n];
    }
    
    /*
     * 141 Linked List Cycle
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if(fast == slow){
                return true;
            }
        }
        
        return false;
    }
    
    
    /*
     * 144.Binary Tree PreOrder Traversal
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        list.add(root.val);
        findnext(root.left, list);
        findnext(root.right, list);
        return list;
    }    
    public static void findnext(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        list.add(root.val);
        findnext(root.left, list);
        findnext(root.right, list);
    }
    
    /*
     * 
     */
    public static int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        for(int i = 0; i < len; i++){
        	char cur = s.charAt(i);
        	
        	if(i != len - 1 && table.get(cur) < table.get(s.charAt(i+1))){
        		sum += (table.get(s.charAt(i+1)) - table.get(cur));
        		i++;
        	}
        	else{
        		sum += table.get(cur);
        	}
        }
        return sum;
    }
    
    /*
     * 
     */
    public static String intToRoman(int num) {
        String res = "";
        int x;
        x = num / 1000;
        num = num % 1000;
        while(x-- != 0)
            res = res + "M";
        
        x = num / 900;
        num = num % 900;
        while(x-- != 0)
            res = res + "CM";
            
        x = num / 500;
        num = num % 500;
        while(x-- != 0)
            res += "D";
            
        x = num / 400;
        num = num % 400;
        while(x-- != 0)
            res += "CD";
            
        x = num / 100;
        num = num % 100;
        while(x-- != 0)
            res += "C";
            
                    
        x = num / 90;
        num = num % 90;
        while(x-- != 0)
            res += "XC";
            
        x = num / 50;
        num = num % 50;
        while(x-- != 0)
            res += "L";
            
        x = num / 40;
        num = num % 40;
        while(x-- != 0)
            res += "XL";
            
        x = num / 10;
        num = num % 10;
        while(x-- != 0)
            res += "X";

        x = num / 9;
        num = num % 9;
        while(x-- != 0)
            res += "IX";

        x = num / 5;
        num = num % 5;
        while(x-- != 0)
            res += "V";
            
                    
        x = num / 4;
        num = num % 4;
        while(x-- != 0)
            res += "IV";
        
                    
        x = num / 1;
        num = num % 1;
        while(x-- != 0)
            res += "I";
        
        return res;

    }
    
    public static void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0; i < A.length; i++){
            switch(A[i]){
                case 0: red++;
                break;
                case 1: white++;
                break;
                case 2: blue++;
                break;
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(red-- > 0){
                A[i] = 0;
            }else if(white-- > 0){
                A[i] = 1;
            }else{
                A[i] = 2;
            }
        }
        
    }
    
    public static int minPathSum(int[][] grid) {
        
        return findmin(grid, 0, 0);
    }
    
    public static int findmin(int[][] grid, int m, int n){

        
        if(m == (grid.length - 1) && n == (grid[0].length - 1)){
            return grid[m][n];
        }
        if(n == grid[0].length - 1){
            return (grid[m][n] + findmin(grid, m + 1, n));
        }else if(m == grid.length - 1){
            return (grid[m][n] + findmin(grid, m, n + 1));
        }else{
            return grid[m][n] + Math.min(findmin(grid, m, n + 1), findmin(grid, m + 1, n));
        }
    }

    /*
     * Permutation
     */
    static boolean [] isUsed;
    static int numLength;
    static ArrayList<ArrayList<Integer>> output;
    static ArrayList<Integer> al;
    
    public static ArrayList<ArrayList<Integer>> permute(int[] num){
    	numLength = num.length;
    	al = new ArrayList<Integer>();
    	output = new ArrayList<ArrayList<Integer>>();
    	isUsed = new boolean[num.length];
    	doPermutation(0, num);
    	return output;
    }
    
    public static void doPermutation(int index, int[] num){
    	if(index == num.length){
    		output.add((ArrayList<Integer>) al.clone());
    		return;
    	}
    	
    	for(int i = 0; i < numLength; i++){
    		if(! isUsed[i]){
    			al.add(num[i]);
    			isUsed[i] = true;
    			doPermutation(index + 1, num);
    			isUsed[i] = false;
    			al.remove(index);
    		}
    	}
    }
    
    
    
    
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++){
            for(int j = 1; j < i; j++){
                temp = (ArrayList<Integer>)row.clone(); 
      
                
            }
            row.add(1);
            result.add((ArrayList<Integer>)row.clone());
        }
        return result;
    }
    
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	combine(n, k, 1, result, new ArrayList<Integer>());
    	return result;
    }
    
    public static void combine(int n, int k, int start,  ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
    	if(k == 0){
    		result.add((ArrayList<Integer>)l.clone());
    		return;
    	}
    	
    	for(int i = start; i <= n; i++){
    		//ArrayList<Integer> a = (ArrayList<Integer>) l.clone();
    		l.add(i);
    		combine(n, k - 1, i + 1, result, l);
    		l.remove(l.size()-1);
    	}
    }   
    
    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        findsum(root, 0);
        return sum;
    }
    
    public static void findsum(TreeNode root, int path){
        if(root == null){
            return;
        }
        path = path*10 + root.val;
        
        if(root.left == null && root.right == null){
            sum += path;
        }else{
            findsum(root.left, path);
            findsum(root.right, path);
        }
        
    }

}