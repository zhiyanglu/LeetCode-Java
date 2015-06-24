
public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(int i = 1; i < 7; i++){
			p.next = new ListNode(i);
			p = p.next;
		}
		
		//the original list:
		p = head;
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}
		
		System.out.println();
		
		new ReorderList().reorderList(head);
		//reordered list:
		p = head;
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}

	}

	/*
	 * O(n) time and O(1) space solution.
	 */
    public void reorderList(ListNode head) {
    	if(head == null) return;
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	//step 1: find the right half
    	while(fast != null && fast.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	//step 2: reverse the right half
    	//		  point the end of left half to null
    	ListNode right = reverseList(slow.next);
    	slow.next = null;
    	
    	//step 3: insert right half into left half
    	ListNode temp;
    	ListNode cur = head;
    	while(right != null){
    		temp = right.next;
    		right.next = cur.next;
    		cur.next = right;
    		cur = right.next;
    		right = temp;
    	}    
    }

	
	
	/*
	 * A O(n^2) solution: keep reversing the right part of the list
	 * TLE
	 */
    public void reorderList2(ListNode head) {
        ListNode current = head;
        
        while(current != null){
        	current.next = reverseList(current.next);
        	current = current.next;
        }
    }
    
    private ListNode reverseList(ListNode head) {
    	if(head == null) return head;
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


}
