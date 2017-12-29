package LC_351_400;

import java.util.Arrays;

public class LC_377_CombinationSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int combinationSum4(int[] nums, int target) {
    	int len = nums.length;
        int[] dp = new int[target+1];
        dp[0]=1;
        Arrays.sort(nums);
        for(int i=1;i<=target;i++){
        	for(int j:nums){
        		if(i<j) break;
        		dp[i] +=dp[i-j];
        	}
        }
        return dp[target];
    }
}
