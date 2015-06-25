import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p = new Point[3];
		p[0] = new Point(2, 3);
		p[1] = new Point(3, 3);
		p[2] = new Point(-5, 3);
//		p[3] = new Point(0, -70);
//		p[4] = new Point(0, -70);
//		p[5] = new Point(1, -1);
//		p[6] = new Point(21, 10);
//		p[7] = new Point(42, 90);
//		p[8] = new Point(-42, -230);


		System.out.println(new MaxPointsOnALine().maxPoints(p));
	}
	
	
	/*
	 * A solution use HashMap and overlap to record duplicate points
	 * For each point, map the slope to number of points on this slope
	 */
	public int maxPoints(Point[] points){
		if(points == null) return 0;
		if(points.length <= 2) return points.length;
		
		Map<Double, Integer> map = new HashMap();
		int result = 0;
		
		for(int i = 0; i < points.length; i++){
			map.clear();
			int overlap = 0;
			int max = 1;
			for(int j = i + 1; j < points.length; j++){
				double slope;
				double x = points[i].x - points[j].x;
				double y = points[i].y - points[j].y;

				if(x == 0 && y == 0){
					overlap++;
					continue;
				}
				if(y == 0){
					slope = Integer.MAX_VALUE;					
				}else if(x == 0)
					slope = 0;
				else
					slope = y / x;
				
				
				if(map.containsKey(slope)){
					map.put(slope, map.get(slope)+1);
					max = Math.max(max, map.get(slope));
				}else{
					map.put(slope, 2);
					max = Math.max(max, 2);
				}
			}
			max += overlap;
			result = Math.max(max, result);
		}

		return result;
	}

}
