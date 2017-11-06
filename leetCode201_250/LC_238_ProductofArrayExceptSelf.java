package leetCode201_250;

public class LC_238_ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int length = nums.length;
        int[] res = new int[length];
        int zeros = 0;
        int pos0 = -1;
        for(int i=0;i<length;i++) {
        	if(nums[i]==0) {
        		pos0 = i;
        		zeros++;
            	if(zeros>=2)
            		break;
        	}else {
        		product *=nums[i];
        	}
        }
        
        switch(zeros) {
        case 0:
        	for(int i=0;i<length;i++) {
        		res[i] = (int) (product/nums[i]);
        	}
        	break;
        case 1:
        		res[pos0] = (int)product;
        	break;
        }
        
        return res;
    }
}
