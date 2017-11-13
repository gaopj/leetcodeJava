package leetCode251_300;

public class LC_278_FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int firstBadVersion(int n) {
        int star =1;
        int end =n;
        while(star<=end) {
        	int mid = star +(end-star)/2;
            if(isBadVersion(mid)) {
            	if(mid-1<1||!isBadVersion(mid-1))
            		return mid;
            	else {
            		end = mid-1;
            	}
            }else {
            	star = mid+1;
            }
        }
        return end;
    }
    boolean isBadVersion(int version) {
    	return false;
    }
}
