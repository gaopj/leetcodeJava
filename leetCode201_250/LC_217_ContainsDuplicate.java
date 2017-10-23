package leetCode201_250;

import java.util.HashSet;
import java.util.Set;

public class LC_217_ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
        	if(s.contains(nums[i])) {
        		return true;
        	}
        	s.add(nums[i]);
        }
        
        return false;
    }
}
