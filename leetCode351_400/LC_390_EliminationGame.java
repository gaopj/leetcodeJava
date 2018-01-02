package leetCode351_400;

public class LC_390_EliminationGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int lastRemaining(int n) {
        return l2r( n);
    }
    int l2r(int n) {
    	if(n==1)
    		return 1;
    	return 2*r2l(n/2);
    }
    
    int r2l(int n) {
    	if(n==1)
    		return 1;
    	if((n&1)==1) {
    		return 2*l2r(n/2);
    	}else {
    		return 2*l2r(n/2)-1;
    	}

    }
}
