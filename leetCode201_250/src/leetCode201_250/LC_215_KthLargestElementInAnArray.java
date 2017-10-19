package leetCode201_250;

import java.util.PriorityQueue;

public class LC_215_KthLargestElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> p = new PriorityQueue<Integer>();
    	
    	for(int i=0;i<nums.length;i++) {
    		p.add(nums[i]);
    		if(p.size()>k) {
    			p.poll();
    		}
    	}
    	return p.peek();
    }
}
