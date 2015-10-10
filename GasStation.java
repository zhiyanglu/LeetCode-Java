/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * @author Lu
 *
 */
public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        
        for(int i = 0; i < gas.length; i++){
            gas[i] -= cost[i];
        }
        
        int cur = 0;
        int start = 0;
        boolean neg = false;
        
        
        for(int i = 0; i < gas.length * 2; i++){
            cur += gas[i % gas.length];
            if(cur < 0){
            	
            	//already tried all the start point and meet the situation that remain gas < 0, fail
                if(i > gas.length - 1) return -1;
                
                //else suppose next index to be the start point
                start = i + 1;
                cur = 0;
            }
        }
        
        return start;
    }

}
