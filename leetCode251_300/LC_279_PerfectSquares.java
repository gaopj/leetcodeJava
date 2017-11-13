package leetCode251_300;

public class LC_279_PerfectSquares {

    public int numSquares(int n) {
        int[] nums = new int[n+1];
        for(int i=0;i*i<=n;i++) {
        	nums[i*i] =1;
        }
        
        for(int i=0;i<=n;i++) {
        	
        	for(int j=0;i+j*j<=n;j++) {
        		if(nums[i+j*j]!=0) {
        			nums[i+j*j] = Math.min(nums[i]+1, nums[i+j*j]);
        		}else {
        			nums[i+j*j] = nums[i]+1;
        		}
        		
        	}
        }
        return nums[n];
    }
}
