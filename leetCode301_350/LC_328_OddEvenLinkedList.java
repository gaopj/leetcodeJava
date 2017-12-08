package LC_301_350;

public class LC_328_OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode oddEvenList(ListNode head) {
    	if(head==null)
    		return head;
        ListNode odd = head;
        ListNode oddTail = head;
        if(head.next==null)
        	return head;
        ListNode even = head.next;
        ListNode evenTail = head.next;
        ListNode pos = evenTail.next;
        oddTail.next=null;
        evenTail.next=null;
        int i=1;
        while(pos!=null){
        	ListNode temp = pos.next;
        	if(i%2==0){
        		evenTail.next = pos;
        		evenTail = evenTail.next;
        	}else{
        		oddTail.next = pos;
        		oddTail = oddTail.next;
        	}
        	i++;
        	pos = temp;
        }
        oddTail.next = even;
        evenTail.next=null;
        return odd;
        
    }
     public class ListNode {
    	      int val;
    	      ListNode next;
    	      ListNode(int x) { val = x; }
    	  }
}
