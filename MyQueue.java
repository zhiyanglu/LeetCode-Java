import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * @author Lu
 *
 */
class MyQueue {
	
	
	public static void main(String[] args){
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.peek();
		q.push(4);
		q.push(5);
		while(!q.empty()){
			System.out.println(q.peek());
			q.pop();
		}
	}
	
	private Stack<Integer> push = new Stack<Integer>();
	private Stack<Integer> pop = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
    	push.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        pop.pop();
    }

    // Get the front element.
    public int peek() {
    	 if(pop.isEmpty()){
    		 while(!push.isEmpty()){
    			 pop.push(push.pop());
    		 }
    	 }
    	return pop.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return push.isEmpty() && pop.isEmpty();
    }
}