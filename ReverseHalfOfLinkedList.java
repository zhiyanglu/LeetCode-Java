/**
 * Amazon 7/13 OA
 * Reverse the right half of a linkedlist
 * @author Lu
 *
 */
public class ReverseHalfOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i = 1; i < 7; i++){
			p.next = new ListNode(i);
			p = p.next;
		}
		
		head = new ReverseHalfOfLinkedList().reverse(head);
		
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}

	}
	
	public ListNode reverse(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode last = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null){
			last = last.next;
			fast = fast.next.next;
		}
		
		ListNode current = last.next;
		while(current.next != null){
			ListNode temp = current.next;
			current.next = temp.next;
			temp.next = last.next;
			last.next = temp;
		}
		return head;
	}

}
