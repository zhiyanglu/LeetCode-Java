import java.util.LinkedList;
import java.util.Queue;


/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * You must use only standard operations of a queue 
 * -- which means only push to back, peek/pop from 
 * front, size, and is empty operations are valid.
 * @author Lu
 */
public class MyStack {
	
	public static void main(String[] args){
		MyStack s = new MyStack();
		s.push(1);
		s.push(2);
		s.push(3);
		while(!s.empty()){
			System.out.println(s.top());
			s.pop();
		}
	}
	
	private Queue<Integer> queue = new LinkedList<Integer>();
	
	/**
	 * O(n) push and O(1) top and O(1) pop
	 * @param x
	 */
	public void push(int x) {
    	queue.add(x);
    	int size = queue.size();
    	for(int i = 0; i < size - 1; i++){
    		queue.add(queue.poll());
    	}
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue.isEmpty())
        	queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}