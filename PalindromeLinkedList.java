/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * 		Could you do it in O(n) time and O(1) space?
 * @author Lu
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode start = new ListNode(1);
		start.next = new ListNode(2);
		start.next.next = new ListNode(3);
		start.next.next.next = new ListNode(1);

		System.out.println(new PalindromeLinkedList().isPalindrome(start));
	}
	
	/**
	 * O(n) complexity O(1) space solution based on list inverse
	 * Inverse the right part of the list and compare it with the left part
	 * @param head
	 * @return
	 */
    public boolean isPalindrome(ListNode head) {
    	int len = 1;
    	if(head == null || head.next == null) return true;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast.next != null && fast.next.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		len++;
    	}
    	slow.next = reverseList(slow.next);
    	ListNode left = head;
    	ListNode right = slow.next;
    	while(len > 0){
    		if(left.val != right.val) return false;
    		left = left.next;
    		right = right.next;
    		len--;
    	}
    	return true;
    }
    private ListNode reverseList(ListNode head){
    	if(head == null) return null;
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
	
	/**
	 * O(n) compleity O(n) space solution
	 * @param head
	 * @return
	 */
    public boolean isPalindrome2(ListNode head) {
        ListNode invert = null;
        ListNode p = head;
        while(p != null){
        	ListNode temp = new ListNode(p.val);
        	temp.next = invert;
        	invert = temp;
        	p = p.next;
        }
        while(invert != null){
        	if(invert.val != head.val) return false;
        	invert = invert.next;
        	head = head.next;
        }
        return true;
    }


}
