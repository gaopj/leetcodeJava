package leetCode201_250;

public class LC_214_ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String shortestPalindrome(String s) {
    	StringBuilder builder = new StringBuilder(s);
    	return builder.reverse().substring(0,s.length()-getCommonLength(s))+s;
    }
    
    private int getCommonLength(String s) {
    	StringBuilder builder = new StringBuilder(s);
    	String rev = new StringBuilder(s).reverse().toString(); 
    	builder.append("#").append(rev);
    	int[] p = new int[builder.length()];
    	for(int i = 1;i<p.length;i++) {
    		int j=p[i-1];
    		while(j>0 && builder.charAt(i)!= builder.charAt(j)) j=p[j-1];
    		p[i] = j==0?(builder.charAt(i) == builder.charAt(0) ? 1 : 0):j+1;
    	}
    	
    	return p[p.length-1];
    }

}
