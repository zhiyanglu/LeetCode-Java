
public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i = 1; i < 6; i++){
			p.next = new ListNode(i);
			p = p.next;
		}
		
		head = new ReverseLinkedListII().reverseBetween(head, 2, 4);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode start = new ListNode(0);
    	start.next = head;
    	ListNode tail = start;
    	ListNode last = null;
    	while(m > 0){
    		last = tail;
    		tail = tail.next;
    		m--;
    		n--;
    	}
    	
    	while(n > 0){
    		ListNode temp = tail.next;
    		tail.next = temp.next;
    		temp.next = last.next;
    		last.next = temp;
    		n--;
    	}
    	return start.next;
    }

    
}
