package leetCode351_400;

import java.util.LinkedList;
import java.util.List;

public class LC_352_DataStreamasDisjointIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class SummaryRanges {

		private List<Interval> mList;
	    /** Initialize your data structure here. */
	    public SummaryRanges() {
	    	mList = new LinkedList<>();
	    }
	    
	    public void addNum(int val) {
	        Interval cur = new Interval(val,val);
	        List<Interval> res = new LinkedList<>();
	        int pos=0;
	        for(Interval i:mList) {
	        	if(cur.end+1<i.start) {
	        		res.add(i);
	        	}else if(cur.start>i.end+1) {
	        		res.add(i);
	        		++pos;
	        	}else {
	        		cur.start = Math.min(cur.start, i.start);
	        		cur.end = Math.max(cur.end, i.end);
	        	}
	        }
	        res.add(pos,cur);
	        mList = res;
	    }
	    
	    public List<Interval> getIntervals() {
	        return mList;
	    }
	}
	
	  public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
}
