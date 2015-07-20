/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author Lu
 *
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Cleaner solution
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode p = start;
        while(l1 != null && l2 != null){
        	p.next = l1.val < l2.val? l1 : l2;
        	p = p.next;
        	l1 = p == l1 ? l1.next : l1;
        	l2 = p == l2 ? l2.next : l2;
        }
        p.next = l1 == null ? l2 : l1;
        return start.next;
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
    	ListNode start = new ListNode(0);
    	ListNode p = start;
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			p.next = l1;
    			l1 = l1.next;
    		}else{
    			p.next = l2;
    			l2 = l2.next;
    		}
    		p = p.next;
    	}
    	if(l1 != null)
    		p.next = l1;
    	else
    		p.next = l2;
    	
    	return start.next;
    }


}
