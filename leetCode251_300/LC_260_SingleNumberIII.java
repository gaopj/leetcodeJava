package leetCode251_300;

public class LC_260_SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] singleNumber(int[] nums) {
        int length = nums.length;
        int axorb =0;
        for(int i=0;i<length;i++) {
        	axorb^=nums[i];
        }
        int bit = (axorb & (~(axorb-1)));
        int res[] = new int[2];
        for(int num:nums) {
        	if((num&bit)==0) {
        		res[0]^=num;
        	}else {
        		res[1]^=num;
        	}
        }
        return res ;
    }
}
