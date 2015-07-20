import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * @author Lu
 *
 */
public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Without extra space
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while(fast != head){
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
	
	/**
	 * With extra space
	 * @param head
	 * @return
	 */
	public ListNode detectCycle2(ListNode head){
		Set<ListNode> set = new HashSet<ListNode>();
		while(head != null){
			if(set.contains(head)) return head;
			else set.add(head);
			head = head.next;
		}
		return null;
	}

	
}
