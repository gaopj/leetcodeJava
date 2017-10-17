package leetCode201_250;

public class LC_213_HouseRobberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		
		int res =rob( nums);
	}

    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length-1;i++) {
        	dp[i] = Math.max(dp[i-1], (i ==1?nums[i]:dp[i-2]+nums[i]));
        }
        int res = dp[nums.length-2];
        
        dp[1] = nums[1];
        for(int i=2;i<nums.length;i++) {
        	dp[i] = Math.max(dp[i-1], (i ==2?nums[i]:dp[i-2]+nums[i]));
        }
        
        return Math.max(res,dp[nums.length-1]);
    }
}
