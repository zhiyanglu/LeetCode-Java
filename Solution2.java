import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;


public class Solution2 {

	
	
	
    public static int reverse(int x) {
        if(x >= 0){
            return reverse_pos(x);
        }
        return x;
    }
    
    public static int reverse_pos(int x){
        int result = 0;
        while(x != 0){
        	if(result < 0 || result > Integer.MAX_VALUE / 10){
            	return 0;
            }
        	System.out.println(result);
        	result = result * 10 + x % 10;
            
            x = x / 10;
        }
        if(result > 0){
        	return result;
        }else{
        	return 0;
        }
    }
    
    /*
     * Pascal's Triangle II
     */
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] result = new int[rowIndex + 1];
        int prev;
        int j = 0;
        while(j <= rowIndex){
            result[j] = 1;
            prev = 1;
            for(int i = 1; i < j; i++){
                int temp = result[i];
                result[i] += prev;
                prev = temp;
            }
            j++;
        }
        for(int i = 0; i < rowIndex + 1; i++){
            list.add(result[i]);
        }
        return list;
    }
    
    /*
     * 
     */
    public static int longestConsecutive(int[] num){
    	int res = 0;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int n : num){
        	if(!map.containsKey(n)){
        		int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
        		int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
        		
        		int sum = left + right + 1;
        		map.put(n, sum);
        		res = Math.max(res, sum);
        		
        		map.put(n - left, sum);
        		map.put(n + right, sum);
        	}else{
        		continue;
        	}
    	}
    	
    	return res;
    }

    
    public static void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        traverse(root, s);
        if(!s.isEmpty()){
            s.pop();
        }
        while(!s.isEmpty()){
            root.right = s.pop();
            root = root.right;
        }
    }
    public static void traverse(TreeNode root, Stack<TreeNode> s){
        if(root == null){
            return;
        }
        traverse(root.right, s);
        traverse(root.left, s);
        s.push(root);
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int k = 0; k <= S.length; k++){
            combine(S, k, 0, list, result);
        }
        return result;
    }
    
    public static void combine(int[] S, int k, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(k == 0){
            result.add((ArrayList<Integer>) list.clone());
            return;
        }
        
        for(int i = start; i < S.length; i++){
            list.add(S[i]);
            combine(S, k-1, i + 1, list, result);
            list.remove(list.size()-1);
        }
    }
    
    /*
     * 
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] pathes = new int[m][n];
        if(obstacleGrid[0][0] != 0){
            pathes[0][0] = 1;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0 && obstacleGrid[i][j] != 1){
                    pathes[i][j] += pathes[i - 1][j];
                }
                if(j > 0 && obstacleGrid[i][j] != 1){
                    pathes[i][j] += pathes[i][j - 1];
                }
            }
        }
        return pathes[m-1][n-1];
    }
    
    private ListNode node;
    
    public TreeNode sortedListToBST(ListNode head){
    	if(head == null){
    		return null;
    	}
    	
    	int size = 0;
    	ListNode runner = head;
    	node = head;
    	while(runner != null){
    		runner = runner.next;
    		size++;
    	}
    	
    	return inorderHelper(0, size - 1);
    }
    
    public TreeNode inorderHelper(int start, int end){
    	if(start > end){
    		return null;
    	}
    	
    	int mid = start + (end - start) / 2;
    	TreeNode left = inorderHelper(start, mid - 1);
    	TreeNode treenode = new TreeNode(node.val);
    	treenode.left = left;
    	node = node.next;
    	
    	TreeNode right = inorderHelper(mid + 1, end);
    	treenode.right = right;
    	
    	return treenode;
    	
    }
    
    public static ArrayList<ArrayList<Integer>> subsetWithDup(int[] num){
    	Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	int len = num.length;
    	if(len == 0) return ans;
    	
    	ans.add(new ArrayList<Integer>());
    	ans.add(new ArrayList<Integer>());
    	ans.get(1).add(num[0]);
    	
    	int nprev = 1;
    	
    	for(int i = 1; i < len; i++){
    		int size = ans.size();
    		if(num[i] != num[i - 1]){
    			nprev = size;
    		}
    		
    		for(int j = size - nprev; j < size; ++j){
    			ArrayList<Integer> l = new ArrayList<Integer>(ans.get(j));
    			l.add(num[i]);
    			ans.add(l);
    		}
    	}
    	
    	return ans;
    }
    
    public static boolean canJump(int[] A) {
        int len = A.length;
        int start = 0;
        for(int i = 0; i < len - 1; ){
            if(i < len - 1 && A[i] == 0){
                if(A[start] != 0){
                    start++;
                    i = start;
                }else{
                    return false;
                }
            }else{
                i += A[i];
            }
        }
        
        return true;
    }
    
    int minpath = 0;
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle.size() == 0){
    		return 0;
    	}
    	minpath += triangle.get(0).get(0);
    	findminpath(triangle, minpath, 1, 0);
    	return minpath;
    }

    public void findminpath(ArrayList<ArrayList<Integer>> triangle, 
    		int path, int level, int index){
    	if(level == triangle.size()){
    		minpath = Math.min(minpath, path);
    		return;
    	}
    
    	findminpath(triangle, path + triangle.get(level).get(index), level+1, index);
    	findminpath(triangle, path + triangle.get(level).get(index), level+1, index+1);
    
    }
    

    public static int reverseBits(int n) {
        int a = 0;
        for(int i = 0; i < 32; i++){
        	a = a << 1;
        	a = a | ((n >> i) & 1);
        }
        return a;
    }

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<Character> temp = new ArrayList<Character>();
        letterCombinations(digits, list, map, 0, temp);
        
        return list;
    }
    
    private static void letterCombinations(String digits, ArrayList<String> list, String[] map, int index, ArrayList<Character> temp){
        
        if(index == digits.length()){
           
            if(temp.size() == 0){
                return;
            }
            String s = "";
            int i = 0;
            while(i < temp.size()){
                s += temp.get(i);
                i++;
            }
            list.add(s);
            return;
        }
        String d = map[(int)(digits.charAt(index) - '2')];
        
        for(int i = 0; i < d.length(); i++){
            temp.add(d.charAt(i));
            letterCombinations(digits, list, map, index + 1, temp);
            temp.remove(temp.size() - 1);
        }
        
    }    

    public static int sublen(String s){
    	System.out.println(s);
    	if(s.equals("")){
    		return 0;
    	}
    	return 1 + sublen(s.substring(1));
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverseBits(1));
    	
    }




}
