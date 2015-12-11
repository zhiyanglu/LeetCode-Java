import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class MinimumHeightTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{1,0},{1,2},{1,3}};
		int n = 4;
		MinimumHeightTrees solution = new MinimumHeightTrees();
		System.out.println(solution.findMinHeightTrees(n, edges));
	}

	
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, ArrayList<Integer>> map = new HashMap();
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!map.containsKey(a)){
                map.put(a, new ArrayList<Integer>());
            }
            if(!map.containsKey(b)){
                map.put(b, new ArrayList<Integer>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int depth = BFS(i,map);
            if(depth == min){
                res.add(i);
            }else if(depth < min){
            	min = depth;
                res = new ArrayList<Integer>();
                res.add(i);
            }
        }
        
        return res;
    }
    private int BFS(int root, Map<Integer, ArrayList<Integer>> map){
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        int depth = 0;
        queue.add(root);
        visited.add(root);
        
        while(!queue.isEmpty()){
            depth++;
            Queue<Integer> next = new LinkedList<Integer>();
            while(!queue.isEmpty()){
                int node = queue.poll();
                for(Integer child : map.get(node)){
                    if(!visited.contains(child)){
                        next.add(child);
                        visited.add(child);
                    }
                }
            }
            queue = next;
        }
        
        return depth;
    }

	
}
