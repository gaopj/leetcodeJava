package leetCode201_250;

import java.util.LinkedList;

public class LC_239_SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int length = nums.length;
        if(length<1)
        	return nums;
        int[] res = new int[length-k+1];
        for(int i=0;i<length;i++) {
        	if(!queue.isEmpty()&&queue.peekFirst()==i-k) 
        		queue.pollFirst();
        	while(!queue.isEmpty()&& nums[queue.peekLast()]<=nums[i])
        		queue.pollLast();
        	queue.add(i);
        	if(i>=k-1) {
        		res[i-k+1] = nums[queue.peekFirst()];
        	}
        }
        
        return res;
        
    }

}
