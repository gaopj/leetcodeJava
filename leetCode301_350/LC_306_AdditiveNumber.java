package leetCode301_350;

public class LC_306_AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for(int i=1;i<=(len-1)/2;i++) {
        	if(i>=2 && num.startsWith("0"))
        		break;
        	for(int j=i+1 ;	len-j>=i&&len-j>=j-i;j++) {
        		if(num.charAt(i)=='0'&&j-i>=2)break;
        		long num1 = Long.parseLong(num.substring(0, i));
        		long num2 = Long.parseLong(num.substring(i,j));
        		if(isAddtive (num.substring(j),num1,num2)) {
        			return true;
        		}
        	}
        		
        }
     return   false;
        
    }
    
    public boolean isAddtive(String s,long n1,long n2) {
    	if(s.equals(""))return true;
    	
    	long sum = n1+n2;
    	String sSum = ""+sum;
    	if(!s.startsWith(sSum)) return false;
    	
    	return isAddtive( s.substring(sSum.length()),n2,sum);
    }
}
