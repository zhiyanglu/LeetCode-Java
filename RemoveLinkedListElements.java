
public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public ListNode removeElements(ListNode head, int val){
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode prev = start;
		while(head != null){
			if(head.val == val) prev.next = head.next;
			else prev = prev.next;				
			
			head = head.next;
		}
		return start.next;
	}
}
