package LC_351_400;

import java.util.Arrays;

public class LC_384_ShuffleanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] res;
    public LC_384_ShuffleanArray(int[] nums) {
    	res = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return res;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int len =res.length;
    	int[] newR = new int[len];
    	newR =Arrays.copyOf(res, len);
    	for(int i=0;i<len;i++){
    		int pos = (int) (Math.random()*len);
    		int temp = newR[pos];
    		newR[pos] = newR[i];
    		newR[i] = temp;
    	}
    	
    	return newR;
    }
}
