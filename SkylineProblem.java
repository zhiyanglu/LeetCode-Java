import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class SkylineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkylineProblem solution = new SkylineProblem();
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10}, {19,24,8}};
		
		System.out.println(solution.getSkyline(buildings));
	}
	
	public class Building{
		int height;
		int left;
		int right;
		public Building(int left, int right, int height){
			this.left = left;
			this.right = right;
			this.height = height;
		}
	}
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList();
        if(buildings == null || buildings.length == 0) return res;
        PriorityQueue<Building> pq = new PriorityQueue<Building>(buildings.length, new Comparator<Building>(){

			@Override
			public int compare(Building o1, Building o2) {
				// TODO Auto-generated method stub
				return o2.height - o1.height;
			}
        	
        });        
        for(int i = 0; i < buildings.length; i++){
        	Building bd = new Building(buildings[i][0], buildings[i][1], buildings[i][2]);
        	pq.offer(bd);
        }
        
        PriorityQueue<Building> skylines = new PriorityQueue<Building>(1, new Comparator<Building>(){
        	public int compare(Building o1, Building o2) {
        		return o1.left - o2.left;
        	}
        });
        
        List<Building> list = new ArrayList<Building>();        

        
        while(!pq.isEmpty()){
        	Building bd = pq.poll();
        	boolean flag = cutEdge(bd, list, pq);
        	if(flag && bd.left < bd.right){
        		skylines.add(bd);
        	}
        }
        
        
        //generate result
        Building prev = new Building(0, skylines.peek().left, 0);
        while(!skylines.isEmpty()){
        	Building cur = skylines.poll();
        	if(cur.left != prev.right){
        		res.add(new int[]{prev.right, 0});
        	}
        	if(cur.height == prev.height){
        		prev.right = cur.right;
        	}else{
            	res.add(new int[]{cur.left, cur.height});        		
            	prev = cur;
        	}
        }
        res.add(new int[]{prev.right, 0});
        return res;
    }    
    private boolean cutEdge(Building bd, List<Building> list, PriorityQueue<Building> pq){
    	for(int i = 0; i < list.size(); i++){
    		Building cover = list.get(i);
    		if(cover.left <= bd.left && cover.right >= bd.right){
    			bd.left = 0;
    			bd.right = 0;
    		}else if(cover.left <= bd.left && cover.right >= bd.left && cover.right <= bd.right){
    			bd.left = cover.right;
    		}else if(cover.right >= bd.right && cover.left >= bd.left && cover.left <= bd.right){
    			bd.right = cover.left;
    		}else if(cover.left > bd.left && cover.right < bd.right){
    			Building leftpart = new Building(bd.left, cover.left, bd.height);
    			Building rightpart = new Building(cover.right, bd.right, bd.height);
    			pq.add(leftpart);
    			pq.add(rightpart);
    			return false;
    		}else{
    			continue;
    		}
    	}
    	if(bd.left < bd.right){
    		list.add(bd);
    	}
    	return true;
    }


}
