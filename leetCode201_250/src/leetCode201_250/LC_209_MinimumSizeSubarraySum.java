package leetCode201_250;

public class LC_209_MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int res =Integer.MAX_VALUE;
        int star=-1,end=0;
        int nowSum=0;
        for(;end<nums.length;end++) {
        	nowSum+=nums[end];
        	if(nowSum<s) {
        		continue;
        	}else {
        		star++;
        		while(star<=end&&nowSum>=s ) {
        			nowSum -=nums[star];
        			star++;
        		}
        		star--;
        		int nowlength = end-star+1;
        		if(nowlength<res)
        			res=nowlength;
        	}
        }
        
        if(res==Integer.MAX_VALUE)
        	return 0;
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums = {1,4,4};
    	minSubArrayLen(4, nums);
	}
}
