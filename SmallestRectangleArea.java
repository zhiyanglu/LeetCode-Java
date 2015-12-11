
public class SmallestRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

    public int minArea(char[][] image, int x, int y) {
        int[] res = new int[4];
        res[0] = image.length;
        res[1] = 0;
        res[2] = image[0].length;
        res[3] = 0;
        
        dfs(image, x, y, res);
        
        return (res[1] - res[0] + 1) * (res[3] - res[2] + 1);
    }
    
    private void dfs(char[][] image, int x, int y, int[] res){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0') return;
        image[x][y] = '0';
        res[0] = Math.min(res[0], x);
        res[1] = Math.max(res[1], x);
        res[2] = Math.min(res[2], y);
        res[3] = Math.max(res[3], y);
        
        dfs(image, x-1, y, res);
        dfs(image, x+1, y, res);
        dfs(image, x, y-1, res);
        dfs(image, x, y+1, res);
    }


}
