
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * A recursive solution. May use stack for recursion
	 * so the space is not constant
	 */
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode f = head.next.next;
		ListNode p = head;
		while(f != null && f.next != null){
			p = p.next;
			f = f.next.next;
		}
		ListNode h2 = sortList(p.next);
		p.next = null;
		
		return merge(sortList(head), h2);		
	}
	
	
	//Merge two Sorted list and return the head;
	public ListNode merge(ListNode h1, ListNode h2){
		ListNode hn = new ListNode(Integer.MIN_VALUE);
		ListNode c = hn;
		while(h1 != null && h2 != null){
			if(h1.val < h2.val){
				c.next = h1;
				h1 = h1.next;
			}else{
				c.next = h2;
				h2 = h2.next;
			}
			c = c.next;
		}
		if(h1 != null){
			c.next = h1;
		}
		if(h2 != null){
			c.next = h2;
		}
		
		return hn.next;
	}

}
