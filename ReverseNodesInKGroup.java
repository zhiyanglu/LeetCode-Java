
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode p = head;
		for(int i = 2; i < 9; i++){
			p.next = new ListNode(i);
			p = p.next;
		}
		p = new ReverseNodesInKGroup().reverseKGroup(head, 4);
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	
	/**
	 * Iterative solution
	 */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
		
		ListNode start = new ListNode(0);
		start.next = head;
		
		ListNode prev = start;
		ListNode tail = head;
		ListNode check;
		
		while(prev != null){
			check = tail;
			for(int i = 1; i < k; i++){
				if(check == null) break;
				check = check.next;			
			}
			if(check == null) break;
			ListNode cur = tail.next;
			int j = k;
			while(--j > 0){
				tail.next = cur.next;
				cur.next = prev.next;
				prev.next = cur;
				cur = tail.next;
			}
			prev = tail;
			tail = tail.next;
		}		
		return start.next;        
    }

	
	/**
	 * Recursive Solution
	 */
	public ListNode reverseKGroup2(ListNode head, int k) {
		if(k == 1) return head;
		
		ListNode check = head;
		for(int i = 1; i < k; i++){
			if(check == null) break;
			check = check.next;			
		}
		if(check == null) return head;
		
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode cur = head.next;
		
		int i = k;
		while(--i > 0){
			head.next = cur.next;
			cur.next = start.next;
			start.next = cur;
			cur = head.next;
		}
		head.next = reverseKGroup(head.next, k);
		return start.next;
    }

}
