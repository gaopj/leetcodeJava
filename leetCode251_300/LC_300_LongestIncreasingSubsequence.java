package leetCode251_300;

public class LC_300_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int lengthOfLIS(int[] nums) {
    	int len = nums.length;
    	if(len<=0)
    		return 0;
        int[] res = new int[len];
        int max=1;
    	res[0] = 1;
    	for(int i=1;i<len;i++) {
    		res[i] = 1;
    		for(int j=0;j<i;j++) {
    			if(nums[i]>nums[j]) {
    				if(res[i]<res[j]+1) {
    					res[i] = res[j]+1;
    				}
    			}
    		}
    		if(res[i]>max)
    			max = res[i];
    	}
    	
    	return max;
    }
}
