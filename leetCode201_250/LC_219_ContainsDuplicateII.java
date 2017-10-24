package leetCode201_250;

import java.util.HashMap;
import java.util.Map;

public class LC_219_ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	if(!m.containsKey(nums[i])) {
        		m.put(nums[i], i);
        	}else {
        		if(i-m.get(nums[i])<=k) {
        			return true;
        		}else {
        			m.put(nums[i], i);
        		}
        	}
        }
        return false;
    }
}
