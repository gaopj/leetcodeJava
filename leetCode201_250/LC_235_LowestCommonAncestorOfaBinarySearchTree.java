package leetCode201_250;

public class LC_235_LowestCommonAncestorOfaBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode head = new TreeNode(5);
		TreeNode p1 = new TreeNode(3);
		TreeNode p2 = new TreeNode(6);
		TreeNode p3 = new TreeNode(2);
		TreeNode p4 = new TreeNode(4);
		TreeNode p5 = new TreeNode(1);
		head.left = p1;
		head.right = p2;
		p1.left = p3;
		p1.right =p4;
		p3.left =p5;
		lowestCommonAncestor(head,p5,p5);
	}

	  public static class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null)
    		return null;
        if(root.val==p.val||root.val==q.val)
        	return root;
        else if(root.val>p.val&&root.val<q.val)
        	return root;
        else if(root.val<p.val&&root.val>q.val)
        	return root;
        else if(root.val<p.val&&root.val<q.val) {
        	return lowestCommonAncestor(root.right, p,  q);
        }
        else {
        	return lowestCommonAncestor(root.left, p,  q);
        }
        
    }
}
