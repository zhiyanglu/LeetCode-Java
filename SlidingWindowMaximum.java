import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from 
 * the very left of the array to the very right. You can only see the k numbers 
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example,
	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
 	 1 [3  -1  -3] 5  3  6  7       3
 	 1  3 [-1  -3  5] 3  6  7       5
 	 1  3  -1 [-3  5  3] 6  7       5
 	 1  3  -1  -3 [5  3  6] 7       6
 	 1  3  -1  -3  5 [3  6  7]      7

 * 
 * Follow up:
 * Could you solve it in linear time?
 * @author Lu
 *
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,1,2,0,5};
		System.out.println(new SlidingWindowMaximum().maxSlidingWindow(nums, 3));
	}
	
	
	/**
	 * 
	 */
	public int[] maxSlidingWindow(int[] a, int k) {     
        if (a == null || k <= 0) {
            return null;
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
	
	/**
	 * O(nlogk) solution using Priority Queue
	 * 
	 */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        
        for(int i = 0; i < k; i++){
        	queue.add(nums[i]);
        }
        result[0] = queue.peek();
        for(int i = k; i < nums.length; i++){
        	queue.remove(nums[i-k]);
        	queue.add(nums[i]);
        	result[i - k + 1] = queue.peek();
        }
        
        return result;
    }

}
