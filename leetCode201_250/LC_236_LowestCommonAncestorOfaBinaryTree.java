package leetCode201_250;

import java.util.Stack;

public class LC_236_LowestCommonAncestorOfaBinaryTree {

	  public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null || p==root ||q==root) return root;
    	TreeNode left=lowestCommonAncestor( root.left ,  p,  q);
    	if(left!=null &&left!=p &&left!=q) return left;
    	TreeNode right=lowestCommonAncestor( root.right,  p,  q);
    	if(right!=null &&right!=p &&right!=q) return right;
    	if(left!=null&&right!=null)
    		return root;
    	return left ==null? right:left;
    }
    

}
