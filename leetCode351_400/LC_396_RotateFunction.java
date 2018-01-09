package LC_351_400;

public class LC_396_RotateFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxRotateFunction(int[] A) {
     
    	int len = A.length;
    	int sum = 0;
    	int temp = 0;
    	for(int i=0;i<len;i++){
    		sum+=A[i];
    		temp += i*A[i];
    	}
    	
    	int res = temp ;
    	for(int i=len-1;i>=0;i--){
    		temp = temp +sum-len*A[i];
    		res = Math.max(res, temp);
    	}
    	
    	return res;
    }
}
