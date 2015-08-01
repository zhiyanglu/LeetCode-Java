/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *  Given linked list: 1->2->3->4->5, and n = 2.
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode p = start;
        while(n-- > 0) fast = fast.next;
        while(fast != null){
            p = p.next;
            fast = fast.next;
        }
        p.next = p.next.next;
        
        return start.next;
    }


}
