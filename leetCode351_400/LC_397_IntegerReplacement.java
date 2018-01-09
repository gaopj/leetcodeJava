package LC_351_400;

public class LC_397_IntegerReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int integerReplacement(int n) {
        if(n<=1)
        	return 0;
        else if(n == Integer.MAX_VALUE)
        	return 32;
        else if(n==3)
        	return 2;
        if((n&1) ==1){
        	return ((n+1)%4==0?integerReplacement(n+1):integerReplacement(n-1))+1;
        }else
        	return integerReplacement(n/2)+1;
    }
    


}
