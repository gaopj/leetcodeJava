package leetCode251_300;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC_257_BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	LinkedList<Integer> li = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {

    	List<String> res  =  new LinkedList<>();
    	if(root==null)
    		return res;
    	BFS(root, res);
    	return res;
    }
    
    void BFS(TreeNode root,List<String> res) {
    	if(root==null)
    		return ;
    	li.addLast(root.val);
    	if(root.left==null&&root.right==null)
    	{
    		String res0 ="";
    		for(int i=0;i<li.size()-1;i++ ){
    			res0 = res0+li.get(i)+"->";
    		}
    		res0=res0+li.get(li.size()-1);
    		res.add(res0);
    	}
    	BFS( root.left, res);
    	BFS( root.right, res);
    	li.removeLast();
    }
}
