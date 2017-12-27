package leetCode351_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_368_LargestDivisibleSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> largestDivisibleSubset(int[] nums) {
    	
    	List<Integer> res = new ArrayList<>();
    	if(nums==null || nums.length ==0)
    		return res;
    	int len = nums.length;
        int[] dp = new int[len];
        int[] last = new int[len];
        
        Arrays.sort(nums);
        
        int max =0;
        int maxpos =0;
        for(int i=0;i<len;++i) {
        	dp[i]=1;
        	last[i] = -1;
        	for(int j=i-1;j>=0;j--) {
        		if(nums[i]%nums[j]==0&& dp[i]<dp[j]+1) {
        			dp[i] = dp[j]+1;
        			last[i] = j;
        		}
        	}
        	if(dp[i]>max) {
        		max=dp[i];
        		maxpos=i;
        	}
        }
        
        while(maxpos!=-1) {
        	res.add(nums[maxpos]);
        	maxpos = last[maxpos];
        }
        return res;
    }
}
