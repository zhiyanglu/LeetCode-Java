import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted 
 * order, not the kth distinct element.
 * @author Lu
 *
 */
public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,6,5,4,3,2,1};
		System.out.println(new KthLargestElementInAnArray().findKthLargest(a, 2));
	}
	

    

	
	/**
	 * O(N) best case / O(N^2) worst case running time + O(1) memory solution
	 * Based on quick sort partition
	 */
	public int findKthLargest(int[] nums, int k){
		k = nums.length - k;	//change k to the position of target in a sorted array
		int lo = 0;
		int hi = nums.length - 1;
		while(lo < hi){
			//get the partition point position
			final int j = partition(nums, lo, hi);
			if(j < k){			//j is less than k, target is in right of j
				lo = j + 1;
			}else if(j > k){	//j is larger than k, target is in left of j
				hi = j - 1;
			}else{				//find target
				break;
			}
		}
		return nums[k];
	}
	/**
	 * put the number x at a[0] to its sorted position by partition the array
	 * and return the position.
	 * all elements on left of x is less than it
	 * all elements on right of x is larger than it
	 */
	public int partition(int[] a, int lo, int hi){
		int i = lo + 1;
		int j = hi + 1;
		while(true){
			//Start from left find the first number that is larger than a[0]
			while(i <= hi && a[i] < a[lo]) i++; 
			//Start from right find the first number that is smaller than a[0]
			while(j > lo && a[lo] < a[--j]);
			//if i >= j, end search, else swap i and j
			if(i >= j){
				break;
			}
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}
	
	
	/**Self-built min-heap solution
	 * O(nlogk) complexity and O(1) space
	 * use given array to build a min-heap
	 */
	public int findKthLargest3(int[] nums, int k){
		if(k > nums.length) return -1;
		//build a min-heap for previous k elements in nums
		for(int i = 0; i < k; i++){
			heapifyUp(nums, i);
		}
		for(int i = k; i < nums.length; i++){
			if(nums[i] > nums[0]){
				nums[0] = nums[i];
				heapifyDown(nums, k);
			}
		}
		return nums[0];
	}
	//change key of root and re-build the heap with O(log k) complexity
	public void heapifyDown(int[] heap, int k){
		int index = 0;
		while(index <= (k-1) / 2){
			int left, right;
			if(index == 0){
				left = 1;
				right = 2;
			}else{
				left = index*2;
				right = index*2 + 1;
			}
			if(right < k){
				int child = heap[left] < heap[right] ? left : right;
				if(heap[index] > heap[child]){
					swap(heap, index, child);
					index = child;
				}else break;
			}else if(left < k){
				if(heap[index] > heap[left]){
					swap(heap, index, left);
					index = left;
				}else break;
			}else{
				break;
			}
		}
	}
	//change key of a children and re-build the heap with O(log k) complexity
	public void heapifyUp(int[] heap, int k){
		while(heap[k] < heap[k / 2]){
			swap(heap, k, k / 2);
			k = k / 2;
		}
	}
	public void swap(int[] num, int a, int b){
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	
	
	/**O(nlogk) complexity O(k) space solution.
	 * Use Java implemented heap
	 */	
	public int findKthLargest2(int[] nums, int k){
		PriorityQueue<Integer> queue = new PriorityQueue();
		
		for(int i = 0; i < k; i++){
			queue.add(nums[i]);
		}
		for(int i = k; i < nums.length; i++){
			if(nums[i] > queue.peek()){
				queue.poll();
				queue.add(nums[i]);
			}
		}
		return queue.poll();
	}
	
	//Sorting O(nlogn) solution
    public int findKthLargest1(int[] nums, int k) {
    	Arrays.sort(nums);
    	return nums[nums.length - k];    	
    }


}
