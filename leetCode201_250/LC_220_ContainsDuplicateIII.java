package leetCode201_250;

import java.util.SortedSet;
import java.util.TreeSet;

public class LC_220_ContainsDuplicateIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0||nums==null||nums.length<2) return false;
        SortedSet<Long> set = new TreeSet<>();
        
        for(int i=0;i<nums.length;i++) {
        	SortedSet<Long> subSet = set.subSet((long)nums[i]-t, (long)nums[i]+t+1);
        	if(!subSet.isEmpty()) return true;
        	
        	if(i>=k) {
        		set.remove(nums[i-k]);
        	}
        	set.add((long)nums[i]);
        }
        
        return false;
    }
}
