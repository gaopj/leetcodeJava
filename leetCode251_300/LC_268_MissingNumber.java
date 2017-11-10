package leetcode;

public class LC_268_MissingNumber {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
    public int missingNumber(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
    	int res = nums.length;
        for(int i=0;i<nums.length;i++){
        	res^=i;
        	res^=nums[i];
        }
        return res;
    }
}
