import java.util.LinkedList;
import java.util.Queue;


public class WallsAndGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		new WallsAndGates().wallsAndGates(rooms);
	}
	

    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == Integer.MAX_VALUE){
                    search(rooms, i, j);
                }
            }
        }
        return;
        
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private void search(int[][] rooms, int x, int y){
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y));

        int step = 0;
        
        while(!q.isEmpty()){
            Queue<Point> nextLevel = new LinkedList<Point>();

            while(!q.isEmpty()){
                Point p = q.poll();
                if(p.x < 0 || p.x >= rooms.length || p.y < 0 || p.y >= rooms[0].length) continue;
                if(visited[p.x][p.y]) continue;
                visited[p.x][p.y] = true;
                if(rooms[p.x][p.y] == -1){
                    continue;
                }else if(rooms[p.x][p.y] == 0){
                    rooms[x][y] = step;
                    return;
                }else{
                    nextLevel.add(new Point(p.x-1, p.y));
                    nextLevel.add(new Point(p.x+1, p.y));
                    nextLevel.add(new Point(p.x, p.y-1));
                    nextLevel.add(new Point(p.x, p.y+1));
                }
            }
            step++;
            q = nextLevel;
        }
    }


}
