package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC_216_CombinationSumIII {

	public static void main(String[] args) {
		combinationSum3(3, 7);
	}

    public static List<List<Integer>> combinationSum3(int k, int n) {
    	Stack<Integer> out = new Stack<Integer>();
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	DFS(k,n,1, out , res);
    	return res;
    }
    
    static void DFS(int k,int n,int start,Stack<Integer> out ,List<List<Integer>> res){
    	if(n==0&&out.size()==k) {
    		List<Integer> res1 = new LinkedList<Integer>();
    		res1.addAll(out);
    		res.add(res1);
    		return;
    	}
    	if(n>0&&out.size()<k){
    	for(int i=start;i<=9;i++){
    		out.push(i);
    		DFS(k,n-i,i+1,out ,res);
    		out.pop();
    	}
    	}
    	return ;
    }
}
