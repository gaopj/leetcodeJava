package LC_351_400;

public class LC_382_LinkedListRandomNode {

	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private
	    ListNode head;
    public LC_382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int res = head.val, i = 2;
        ListNode cur = head.next;
        while (cur!=null) {
            int j = ((int) (Math.random()*1000000) % i);
            if (j == 0) res = cur.val;
            ++i;
            cur = cur.next;
        }
        return res;
    }
}
