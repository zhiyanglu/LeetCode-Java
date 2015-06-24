
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode reverseList(ListNode head) {
    	if(head == null) return head;
    	ListNode start = new ListNode(0);
        start.next = head;

        ListNode last = head;
        ListNode current = head.next;
        while(current != null){
        	last.next = current.next;
        	current.next = start.next;
        	start.next = current;
        	current = last.next;
        }
        
        return start.next;
    }


}
