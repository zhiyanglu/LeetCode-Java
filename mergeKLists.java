import java.util.Comparator;
import java.util.PriorityQueue;


public class mergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0) return null;
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
			
		});
		
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		for(ListNode node:lists){
			if(node != null) queue.add(node);
		}
		
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			
			if(tail != null && tail.next != null){
				queue.add(tail.next);
			}
		}
		
		return head.next;
	}

}
