package leetCode201_250;

public class LC_230_KthSmallestElementinaBST {

	 public class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	
	int now =0;
	int res =-1;
    public int kthSmallest(TreeNode root, int k) {
    	
    	mid(root, k);
    	return res;
    }
	
    public void mid(TreeNode root, int k) {
    	
    	if(res!=-1)
    		return ;
        if(root!=null){
        	kthSmallest( root.left, k);
        	now ++;
        	if(now ==k){
        		res = root.val;
        	}
        	kthSmallest( root.right,  k);
        }
    }
}
