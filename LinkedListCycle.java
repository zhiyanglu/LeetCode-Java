/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * @author Lu
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
