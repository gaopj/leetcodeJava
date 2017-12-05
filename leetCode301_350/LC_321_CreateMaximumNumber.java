package leetCode301_350;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC_321_CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> res0 = new ArrayList<>();
        for(int i = Math.max(0, k-n);i<=k&&i<=m;i++) {
        	List<Integer> m1 = maxArray(nums1,i);
        	List<Integer> m2 = maxArray(nums2,k-i);
        	List<Integer> temp = merge(m1,m2,k);
        	if(greater(temp,0,res0,0)) res0 = temp;
        }
        
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
        	res[i] = res0.get(i);
        }
    	return res;
    }
    
    List<Integer> maxArray(int[] nums,int k){
    	int n = nums.length;
    	Stack<Integer> s = new Stack<>();
    	for(int i=0;i<n;i++) {
    		while(n-i+s.size()>k && !s.isEmpty() && s.peek()<nums[i]) s.pop();
    		if(s.size()<k) s.push(nums[i]);
    	}
    	return s;
    }

    
    boolean greater(List<Integer> nums1,int i,List<Integer> nums2,int j) {
    	while(i<nums1.size()&& j<nums2.size() && nums1.get(i)==nums2.get(j)) {
    		i++;
    		j++;
    	}
    	return j==nums2.size() || (i<nums1.size() && nums1.get(i)>nums2.get(j));
    }
    
    List<Integer> merge(List<Integer> nums1,List<Integer> nums2,int k){
    	List<Integer> res = new ArrayList<>();
    	int i=0,j=0;
    	for(int r=0;r<k;r++) {
    		if(greater(nums1,i,nums2,j)) res.add(nums1.get(i++));
    		else res.add(nums2.get(j++));
    	}
    	return res;
    }
}
