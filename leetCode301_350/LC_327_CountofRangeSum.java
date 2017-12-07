package leetCode301_350;

public class LC_327_CountofRangeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long[] counts;
	int lower ,upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int length = nums.length;
        this.lower = lower;
        this.upper = upper;
        if(length<=0)
        	return 0;
        counts = new long[nums.length];
        counts[0] = nums[0];
        
        for(int i=1;i<nums.length;i++) {
        	counts[i] = counts[i-1]+nums[i];
        }
        return countNum( nums,0,length-1);
    }
        
        private int countNum(int[] nums,int left,int right) {
            if(left == right){
                if(nums[left] >=lower && nums[right] <= upper)
                    return 1;
                return 0;
            }
            int mid = (left+right)/2;
            int total = 0;
            for(int i = left;i<=mid;i++){
                for(int j = mid+1;j<=right;j++){
                    long tmpNum = counts[j] - counts[i] + nums[i];
                    if(tmpNum >= lower && tmpNum <= upper)
                        ++total;
                }
            }
            //���ö��ַ�
            return total + countNum(nums,left,mid) + countNum(nums,mid+1,right);
        }
        
 }

