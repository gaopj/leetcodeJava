package leetCode301_350;

public class LC_337_HouseRobberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int rob(TreeNode root) {
    	int[] res = new int[2];
    	res = robHelp( root);
    	return Math.max(res[0], res[1]);
    }
    
    private int[] robHelp(TreeNode root) {
    	int[] res = new int[2];
    	int[] left,right;
        if(root!=null) {
        	left = robHelp(root.left);
        	right = robHelp(root.right);
        	res[0] =root.val+left[1]+right[1];  //ȡroot
        	res[1] =Math.max(left[0],left[1])+Math.max(right[0],right[1]);  //ȡroot
        }
        return res;   
    }
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}
