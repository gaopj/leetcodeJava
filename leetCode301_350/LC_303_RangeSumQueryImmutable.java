package leetCode301_350;

import java.util.ArrayList;
import java.util.List;

public class LC_303_RangeSumQueryImmutable {

}

class NumArray {

	List<Integer> sum = new ArrayList<>();
	int[] nums;
    public NumArray(int[] nums) {
    	this.nums = nums;
    	if(nums.length<1)
    		return;
    	sum.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
        	sum.add(sum.get(i-1)+nums[i]);
        }
    }
    
    public int sumRange(int i, int j) {
        return sum.get(j)-sum.get(i)+nums[i];
    }
}
