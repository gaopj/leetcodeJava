package leetCode251_300;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LC_297_SerializeandDeserializeBinaryTree {


	private static final String NULL_NODE = "#";
	private static final String DELIMITER = ",";
	   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root,StringBuilder sb) {
    	if(root ==null) {
    		sb.append(NULL_NODE).append(DELIMITER);
    	}else {
    		sb.append(root.val).append(DELIMITER);
    		serialize( root.left, sb);
    		serialize( root.right, sb);
    	}
    	
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       Queue<String> q = new LinkedList<>();
       Collections.addAll(q, data.split(DELIMITER+""));
       return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> q) {
        if(q.isEmpty()) return null;
        String s = q.poll();
        TreeNode root = null;
        if(!s.equals(NULL_NODE)) {
        	root = new TreeNode(Integer.valueOf(s));
        	root.left  =deserialize( q);
        	root.right  =deserialize( q);
        }
        return root;
    }
    
     public class TreeNode {
    	      int val;
    	     TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
}
