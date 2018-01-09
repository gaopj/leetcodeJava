package LC_351_400;

public class LC_398_RandomPickIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] num = {1,2,3,3,3};
		LC_398_RandomPickIndex l = new LC_398_RandomPickIndex(num);
		l.pick(3);
	}

    public LC_398_RandomPickIndex(int[] nums) {
        this.nums = nums;
    }
    
    int[] nums;
    public int pick(int target) {
        int cnt =0;
        int res =-1;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=target)
        		continue;
        	else {
        		cnt++;
        		if((int)(Math.random()*Integer.MAX_VALUE)%cnt ==0){
        			res = i;
        		}
        	}
        }
        return res;
    }
}
