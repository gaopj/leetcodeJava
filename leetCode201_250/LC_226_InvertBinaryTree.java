package leetCode201_250;

public class LC_226_InvertBinaryTree {

	  public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode invertTree(TreeNode root) {
    	if (root==null)
    		return null;
    	else if(root.left!=null||root.right!=null) {
        	TreeNode temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	invertTree(root.left);
        	invertTree(root.right);
        	return root;
        }else return root;
    }
}
