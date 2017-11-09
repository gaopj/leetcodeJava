package leetCode251_300;

public class LC_263_UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isUgly(int num) {
        if(num<=0)
        	return false;
        while(num>=2&&num%2==0) {
        	num/=2;
        }
        while(num>=3&&num%3==0) {
        	num/=3;
        }
        while(num>=5&&num%5==0) {
        	num/=5;
        }
        return num==1;
    }
}
