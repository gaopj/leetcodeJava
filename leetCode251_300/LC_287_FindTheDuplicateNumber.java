package leetCode251_300;

public class LC_287_FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int findDuplicate(int[] nums) {
        if(nums.length>1) {
        	int slow = nums[0];
        	int fast = nums[nums[0]];
        	
        	while(slow!=fast) {
        		slow = nums[slow];
        		fast = nums[nums[fast]];
        	}
        	
        	fast = 0;
        	while(fast!=slow) {
        		fast = nums[fast];
        		slow = nums[slow];
        	}
        	return slow;
        }
        return -1;
    }
}
