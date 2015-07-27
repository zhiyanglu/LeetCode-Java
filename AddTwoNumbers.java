/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * @author Lu
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode start = new ListNode(0);
        ListNode current = start;
        while(l1 != null && l2 != null){
            int bit = l1.val + l2.val + carry;
            if(bit > 9){
                bit = bit % 10;
                carry = 1;
            }else
                carry = 0;
            current.next = new ListNode(bit);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 == null ? l2 : l1;
        while(remain != null || carry != 0){
            int bit = remain == null ? carry : remain.val + carry;
            if(bit > 9){
                bit = bit % 10;
                carry = 1;
            }else
                carry = 0;
            current.next = new ListNode(bit);
            current = current.next;
            if(remain != null) remain = remain.next;
        }
        return start.next;
    }


}
