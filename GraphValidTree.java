import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * @author Lu
 *
 */
public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * DFS/BFS solution
	 * @param n
	 * @param edges
	 * @return
	 */
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return n == 1;
        Map<Integer, Set<Integer>> map = new HashMap();

        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(!map.containsKey(a)){
                map.put(a, new HashSet<Integer>());
            }
            if(!map.containsKey(b)){
                map.put(b, new HashSet<Integer>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(edges[0][0]);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited.contains(node)) return false;
            visited.add(node);
            
            for(Integer child : map.get(node)){
                map.get(child).remove(node);
                stack.push(child);
            }
            map.remove(node);
        }
        
        return edges.length == n - 1;
    }
}
