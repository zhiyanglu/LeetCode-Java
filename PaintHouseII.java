
public class PaintHouseII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = {{3,14,12,2,20,16,12,2},{9,6,9,8,2,9,20,18},{20,2,20,4,5,12,11,11},{16,3,7,5,15,2,2,4},{17,3,11,1,9,5,7,11}};
		new PaintHouseII().minCostII(costs);
	}
	


    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        
        int lastMin1 = -1;
        int lastMin2 = -1;
        for(int i = 0; i < k; i++){
            if(lastMin1 == -1){
                lastMin1 = i;
            }else if(lastMin2 == -1){
                lastMin2 = i;
                if(costs[0][lastMin1] > costs[0][lastMin2]){
                    int temp = lastMin1;
                    lastMin1 = lastMin2;
                    lastMin2 = temp;
                }
            }else if(costs[0][i] < costs[0][lastMin1]){
                lastMin2 = lastMin1;
                lastMin1 = i;
            }else if(costs[0][i] < costs[0][lastMin2]){
                lastMin2 = i;
            }
        }
        
        for(int i = 1; i < n; i++){
            int curMin1 = -1;
            int curMin2 = -1;
            for(int j = 0; j < k; j++){
                if(j != lastMin1){
                    costs[i][j] += costs[i-1][lastMin1];
                }else{
                    costs[i][j] += costs[i-1][lastMin2];
                }
                
                if(curMin1 == -1){
                    curMin1 = j;
                }else if(curMin2 == -1){
                    curMin2 = j;
                    if(costs[i][curMin1] > costs[i][curMin2]){
                        int temp = curMin1;
                        curMin1 = curMin2;
                        curMin2 = temp;
                    }
                }else if(costs[i][j] < costs[i][curMin1]){
                    curMin2 = curMin1;
                    curMin1 = j;
                }else if(costs[i][j] < costs[i][curMin2]){
                    curMin2 = j;
                }
            }
            lastMin1 = curMin1;
            lastMin2 = curMin2;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            min = Math.min(costs[n-1][i], min);
        }
        
        return min;
    }


}
