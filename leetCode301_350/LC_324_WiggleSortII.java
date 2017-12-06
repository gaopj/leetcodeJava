package leetCode301_350;

import java.util.ArrayList;
import java.util.Arrays;

public class LC_324_WiggleSortII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public void wiggleSort(int[] nums) {
    	int[] temp = new int[nums.length];
    	temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for(int i=0;i<nums.length;++i) {
        	if(i%2==0) {
        		nums[i] = temp[(nums.length-1)/2-i/2];
        	}else {
        		nums[i] = temp[(nums.length-1)-i/2];
        	}
        }
    }
}
