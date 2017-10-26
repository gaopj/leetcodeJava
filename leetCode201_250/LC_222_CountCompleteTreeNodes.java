package leetCode201_250;

public class LC_222_CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 class TreeNode { 
		      int val; 
		      TreeNode left; 
		      TreeNode right; 
		 }; 
	int countNodes(TreeNode root) {
		if(root==null) return 0;
		int leftDepth =0;
		int rightDepth =0;
		for(TreeNode node = root ;node!=null;node =node.left ) {
			leftDepth++;
		}
		for(TreeNode node = root ;node!=null;node =node.right ) {
			rightDepth++;
		}
		if(leftDepth==rightDepth) {
			return (1<<leftDepth) -1;
		}else {
			return countNodes(root.left)+countNodes(root.right) +1;
		}
		
	}
}
