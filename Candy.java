
public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rate = {1, 0, 2};
		new Candy().candy(rate);
	}
	
	/*
	 * This solution picks each element from the input array only once. 
	 * First, we give a candy to the first child. Then for each child we have three cases:
	 * His/her rating is equal to the previous one -> give 1 candy.
	 * His/her rating is greater than the previous one -> give him (previous + 1) candies.
	 * His/her rating is less than the previous one -> don't know what to do yet, let's just count the number of such consequent cases.
	 */
    public int candy(int[] ratings) {
    	if(ratings.length == 0) return 0;
    	    	
    	int prev = 1;
    	int total = 1;
    	int count = 0;
    	
    	for(int i = 1; i < ratings.length; i++){    		
			if (ratings[i] >= ratings[i - 1]) {
				if(count > 0){
					total += count * (count + 1) / 2;
					if(count >= prev) total += count + 1 - prev;
					count = 0;
					prev = 1;
				}
				prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
				total += prev;
			}else{
				count++;
			}    		
    	}
    	if(count > 0){
    		total += count * (count + 1) / 2;
    		if(count >= prev) total += count - prev + 1;
    	}    	    	
    	return total;
    }
    


}
