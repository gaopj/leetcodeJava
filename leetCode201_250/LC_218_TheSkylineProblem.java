package leetCode201_250;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LC_218_TheSkylineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class MaxCom implements Comparator<Integer>{
		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg1-arg0;
		}
		
	}
	
	public class ArrayCom implements Comparator<int[]>{
		@Override
		public int compare(int[] arg0, int[] arg1) {
			if(arg0[0]!=arg1[0]) return arg0[0] - arg1[0];
			else return arg1[1] - arg0[1];
		}
		
	}

    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> res = new LinkedList<>();
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxCom());
    	List<int[]> lines = new LinkedList<>();
    	
    	for(int i=0;i<buildings.length;i++) {
    		int[] temp = buildings[i];
    		lines.add(new int[] {temp[0],temp[2]});
    		lines.add(new int[] {temp[1],-temp[2]});
    	}
    	Collections.sort(lines,new ArrayCom());
    	
    	int cur=0,pre = 0;
    	for(int i=0;i<lines.size();i++) {
    		int[] temp = lines.get(i);
    		if(temp[1]>0) {
    			maxHeap.offer(temp[1]);
    			cur = maxHeap.peek();
    		}else {
    			maxHeap.remove(-temp[1]);
    			cur = (maxHeap.peek() == null?0:maxHeap.peek());
    		}
    		if(cur !=pre) {
    			res.add(new int[] {temp[0],cur});
    			pre = cur;
    		}
    	}
    	
    	return res;
    }
}
