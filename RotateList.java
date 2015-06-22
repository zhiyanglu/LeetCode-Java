
public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        
        ListNode count = head;
        int c = 0;
        while(count != null){
            count = count.next;
            c++;
        }
        k = k % c;
        
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode result = null;
    	while(fast != null && k > 0){
    		fast = fast.next;
    		k--;
    	}
    	
    	if(fast == null) return head;

    	    	
    	while(fast.next != null){
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	fast.next = head;
    	result = slow.next;
    	slow.next = null;
    	
        return result;

     }


}
