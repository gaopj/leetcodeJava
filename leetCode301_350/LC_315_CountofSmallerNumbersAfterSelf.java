package LC_301_350;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC_315_CountofSmallerNumbersAfterSelf {


 //    public static List<Integer> countSmaller(int[] nums) {
//    	List<Integer> list  = new LinkedList<>();
//    	LinkedList<Integer> res = new LinkedList<>();
//    	for(int i=nums.length-1;i>=0;i--){
//    		int s = 0,e =list.size();
//    		while(s<e){
//    			int mid  =s +(e-s)/2;
//    			if(nums[i]<=list.get(mid)){
//    				e = mid;
//    			}else if(nums[i]>list.get(mid)){
//    				s = mid+1;
//    			}		
//    		}
//    		list.add(s,nums[i]);
//    		res.addFirst(s);
//    	}
//    	return res;
//    }
	private class Node{
		int val,smaller;
		Node left,right;
		public Node(int v,int s ){
			val = v;
			smaller = s;
		}
	}
	int insert(Node root,int v,Node nowNode){
		if(root==null){
			root = nowNode;
			return 0;
		}
		else{
			if(root.val>v)
			{
				root.smaller++;
				return insert(root.left,v,nowNode);
			}else{
				return insert(root.right,v,nowNode)+root.smaller+((root.val<v)?1:0);
			}
		}
	}
    public  List<Integer> countSmaller(int[] nums) {
    	LinkedList<Integer> res = new LinkedList<>();
    	if(nums.length<1)
    		return res;
    	Node root1=null;
    	for(int i=nums.length-1;i>=0;i--){
    		Node node = new Node(nums[i],0);
    		int res0=insert(root1,nums[i],node);
    		root1 = node;
    		res.addFirst(res0);
    		
    	}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LC_315_CountofSmallerNumbersAfterSelf m = new LC_315_CountofSmallerNumbersAfterSelf();
		int[] nums = {5,2,6,1};
		List<Integer> res =m.countSmaller( nums);
	}
}
