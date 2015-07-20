/**
 * Write a program to find the node at which the 
 * intersection of two singly linked lists begins.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * @author Lu
 *
 */
public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * No extra space O(m+n) time
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null) return null;
    	ListNode pA = headA;
    	ListNode pB = headB;
    	while(pA != pB){
    		pA = pA==null ? headB : pA.next;
    		pB = pB==null ? headA : pB.next;
    	}
    	return pA;
    }


}
