
public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * O(n) Recursive solution
	 */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode p = head.next;
        head.next = swapPairs(p.next);
        p.next = head;

        return p;
        
    }
	
	/** 
	 * O(n) Iterative solution
	 */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode prev = start;
        ListNode cur = head;
        ListNode next;
        
        while(cur != null && cur.next != null){
            next = cur.next;
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        
        return start.next;
        
    }


}
