import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you 
 * have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of 
 * them. If it is impossible to finish all courses, return an empty array.
 * @author Lu
 */
public class CourseScheduleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pre = {{0,1},{0,2},{1,2}};
		new CourseScheduleII().findOrder(3, pre);
	}
	
	
	//DFS topological sorting solution
	
	
	//BFS topological sorting solution
    public int[] findOrder(int numCourses, int[][] prerequisites) {

    	HashSet<Integer>[] isPre = new HashSet[numCourses];
    	int[] incomings = new int[numCourses];
    	for(int i = 0; i < isPre.length; i++){
    		isPre[i] = new HashSet();
    	}
    	for(int i = 0; i < prerequisites.length; i++){
    		int course = prerequisites[i][0];
    		int pre = prerequisites[i][1];
    		if(isPre[pre].contains(course)){	//skip duplicate case
    			continue;
    		}
    		isPre[pre].add(course);    		
    		incomings[course]++;
    	}
    	
    	LinkedList<Integer> queue = new LinkedList();
    	for(int i = 0; i < numCourses; i++){
    		if(incomings[i] == 0){
    			queue.add(i);
    		}
    	}
    	
    	List<Integer> list = new ArrayList<Integer>();
    	while(!queue.isEmpty()){
    		int takenPre = queue.poll();
    		list.add(takenPre);
    		for(Integer course : isPre[takenPre]){
    			if(--incomings[course] == 0){
    				queue.add(course);
    			}
    		}
    	}
    	
    	if(numCourses != list.size()){
    		return new int[0];
    	}else{
    		int[] result = new int[numCourses];
    		for(int i = 0; i < numCourses; i++){
    			result[i] = list.get(i);
    		}
    		return result;
    	}    	    	
    	
    }

    

}
