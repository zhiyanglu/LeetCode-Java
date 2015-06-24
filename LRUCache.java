import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Use Double LinkedList and HashTable
 */
public class LRUCache {

	class DListNode{
		int key;
		int value;
		DListNode prev;
		DListNode next;
		public DListNode(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Map<Integer, DListNode> map;
	private int count;
	private int capacity;
	private DListNode head;
	private DListNode tail;
	
    public LRUCache(int capacity) {
    	map = new HashMap<Integer, DListNode>();
    	count = 0;
    	this.capacity = capacity;
    	head = new DListNode(-1, -1);
    	tail = new DListNode(-1, -1);
    	head.next = tail;
    	tail.prev = head;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)){
    		DListNode cur = map.get(key);
    		cur.prev.next = cur.next;
    		cur.next.prev = cur.prev;
    		cur.next = tail;
    		cur.prev = tail.prev;
    		tail.prev.next = cur;
    		tail.prev = cur;
    		return cur.value;
    	}else{    		
        	return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		DListNode cur = map.get(key);
    		cur.prev.next = cur.next;
    		cur.next.prev = cur.prev;
    		cur.next = tail;
    		cur.prev = tail.prev;
    		tail.prev.next = cur;
    		tail.prev = cur;
    		cur.value = value;
    	}else{
			DListNode new_node = new DListNode(key, value);
			new_node.next = tail;
			new_node.prev = tail.prev;
			tail.prev.next = new_node;
			tail.prev = new_node;
			map.put(key, new_node);
    		if(count < capacity){
    			count++;
    		}else{
    			map.remove(head.next.key);
    			head.next = head.next.next;
    			head.next.prev = head;
    		}
    	}
    }

}
