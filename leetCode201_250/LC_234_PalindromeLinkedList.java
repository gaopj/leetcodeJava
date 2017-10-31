package leetCode201_250;

public class LC_234_PalindromeLinkedList {

	  public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(2);
		ListNode p4 = new ListNode(1);
		head.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		boolean res= isPalindrome(head);
		
	}

    public static boolean isPalindrome(ListNode head) {
    	if(head==null)
    		return true;
    	if(head.next==null)
    		return true;
    	ListNode p1 =head;
    	ListNode p2 =head;
    	while(p2.next!=null&&p2.next.next!=null) {
    		p1 = p1.next;
    		p2 =p2.next.next;
    	}
    	ListNode now =p1.next;
    	p1.next=null;
    	ListNode newH = now;
    	now = now.next;
    	newH.next=null;
    	while(now!=null) {
    		ListNode temp = now.next;
    		now.next = newH;
    		newH = now;
    		now = temp;
    	}
    	p1 = head;
    	p2 = newH;
    	while(p2!=null){
    		if(p1.val!=p2.val)
    			return false;
    		p1 = p1.next;
    		p2 =p2.next;
    	}
    	return true;
    }
}
