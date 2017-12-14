package leetCode301_350;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_341_FlattenNestedListIterator {

	  public  interface NestedInteger {
			 
		     // @return true if this NestedInteger holds a single integer, rather than a nested list.
		      public boolean isInteger();
		 
		      // @return the single integer that this NestedInteger holds, if it holds a single integer
		      // Return null if this NestedInteger holds a nested list
		      public Integer getInteger();
		 
		      // @return the nested list that this NestedInteger holds, if it holds a nested list
		      // Return null if this NestedInteger holds a single integer
		      public List<NestedInteger> getList();
		  }
	public class NestedIterator implements Iterator<Integer> {


		Queue<Integer> q ;
	    public NestedIterator(List<NestedInteger> nestedList) {
	    	q = new LinkedList<Integer>();
	    	init(nestedList);	
	    }

	    void init(List<NestedInteger> nestedList) {
	    	if(nestedList==null ||nestedList.size()==0)
	    		return;
	    	for(NestedInteger i:nestedList) {
	    		if(i.isInteger())
	    			q.offer(i.getInteger());
	    		else {
	    			init(i.getList());
	    		}
	    	}
	    }
	    
	    @Override
	    public Integer next() {
	        return q.poll();
	    }

	    @Override
	    public boolean hasNext() {
	        return !q.isEmpty();
	    }
	}
}
