import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * Examples: 
	[2,3,4] , the median is 3
	[2,3], the median is (2 + 3) / 2 = 2.5
	
	Design a data structure that supports the following two operations:
	void addNum(int num) - Add a integer number from the data stream to the data structure.
	double findMedian() - Return the median of all elements so far.
 * @author Lu
 *
 */
public class MedianFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		mf.addNum(5);
		mf.addNum(6);
//		mf.addNum(7);

		System.out.println(mf.findMedian());
	}

    // Adds a number into the data structure.
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder(){
        //a maxHeap contains the smaller half of the numbers
        left = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2){
                    return o2 - o1;
                }
            });
        
        //a minHeap contains the larger half of the numbers
        right = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(left.size() == 0 && right.size() == 0){
            left.add(num);
        }else if(num > left.peek()){
            right.add(num);
        }else{
            left.add(num);
        }
        balanceHeap();
    }
    private void balanceHeap(){
        if(left.size() - right.size() > 1){
            right.add(left.poll());
        }else if(right.size() - left.size() > 1){
            left.add(right.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }else{
            return left.size() > right.size() ? left.peek() : right.peek();
        }
    }

	
}
