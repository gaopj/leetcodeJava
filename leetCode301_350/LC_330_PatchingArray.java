package leetCode301_350;

public class LC_330_PatchingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int minPatches(int[] nums, int n) {
        int res =0;
        long miss=1;
        int pos = 0;
        while(miss<=n) {
        	if(pos<nums.length && nums[pos]<=miss)
        		miss+=nums[pos++];
        	else {
        		miss= miss<<1;
        		res++;
        	}
        }
        return res;
    }
}
