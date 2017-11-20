package leetCode251_300;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_295_FindMedianfromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	PriorityQueue<Integer> minHeap = new PriorityQueue<>(100,new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg0-arg1;
		}
		
	});
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(100,new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg1-arg0;
		}
		
	});
    
    public void addNum(int num) {
    		if(maxHeap.size()!=0&&num<maxHeap.peek()) {
    			maxHeap.add(num);
    			minHeap.add(maxHeap.poll());
    		}else
    		{
    			minHeap.add(num);
    		}
        balance();
    }
    
    private void balance() {
    	int h1 = maxHeap.size();
    	int h2 = minHeap.size();
    	if(h2-h1<=1)
    		return;
    	else {
    		maxHeap.add(minHeap.poll());
    	}
    	
    }
    public double findMedian() {
    	double res =0;
    	int h1 = maxHeap.size();
    	int h2 = minHeap.size();
    	if(h2>h1)
    		res = minHeap.peek();
    	else {
    		if(h2!=0)
    			res = (minHeap.peek()+maxHeap.peek())*1.0/2 ;
    	}
    	
    	return res;
    }
}
