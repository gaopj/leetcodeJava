package leetCode301_350;

public class LC_313_SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] primes = {2, 7, 13, 19};
		int res = nthSuperUglyNumber( 12, primes);
	}

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] res =new int[n];    
        int[] pointer = new int[primes.length];
        if(n<=0)
        	return 0;
        if(n==1)
        	return 1;
        res[0]=1;
        for(int i=1;i<n;i++) {
        	int min =Integer.MAX_VALUE;
        	int pos = -1;
        	for(int j=0;j<primes.length;j++) {
        		if(min>res[pointer[j]]*primes[j]) {
        			min = res[pointer[j]]*primes[j];
        		}
        	}
        	res[i] = min;
        	for(int j=0;j<primes.length;j++) {
        		if(min==res[pointer[j]]*primes[j]) {
        			pointer[j]++;
        		}
        	}
        }
        return res[n-1];
    }
}
