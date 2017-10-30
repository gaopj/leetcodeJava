package leetCode201_250;

import java.util.LinkedList;
import java.util.List;

public class LC_229_MajorityElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> res = new LinkedList<Integer>();
    	int length = nums.length;
    	if(length==0)
    		return res;
    	else if(length==1)
    	{
    		res.add(nums[0]);
    		return res;
    	}
    	int m1 = nums[0];
    	int m2 = -1;
    	int c1=1;
    	int c2 =0;
    	for(int i=1;i<length;i++) {
    		if(nums[i]==m1) {
    			c1++;
    		}else if(nums[i]==m2){
    			c2++;
    		}else if(c1==0) {
     			m1 = nums[i];
    			c1 = 1;
    		}else if(c2==0) {
    			m2 = nums[i];
    			c2 = 1;
    		}
    		else {
    			c1--;
    			c2--;
    		}
    	}
    	
    	c1 =0;c2 = 0;
    	for(int i=0;i<length;i++) {
    		if(m1 ==nums[i]) ++c1;
    		else if (m2 ==nums[i]) ++c2;
    	}
    	
        if(c1>length/3) res.add(m1);  
        if(c2>length/3) res.add(m2);
    	return res;
    }
}
