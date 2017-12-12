package leetCode301_350;

public class LC_334_IncreasingTripletSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int n:nums) {
        	if(firstMin>n) firstMin=n;
        	else if(secondMin>n) secondMin=n;
        	else return true;
        }
        return false;
    }
}
