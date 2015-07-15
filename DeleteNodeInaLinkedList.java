/**
 * Write a function to delete a node (except the tail) in a 
 * singly linked list, given only access to that node.
 * @author Lu
 *
 */
public class DeleteNodeInaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void deleteNode(ListNode node) {
        if(node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
