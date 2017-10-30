package leetCode201_250;

public class LC_233_NumberofDigitOne {
    public int countDigitOne(int n) {
    	long res =0;
    	long temp =1;
        for(;temp<=n;temp*=10){
        	long a =n/temp;
        	long b =n%temp;
        	res += (a+8)/10 *temp +((a%10)==1?b+1:0);
        }
        return (int)res;
    }
}
