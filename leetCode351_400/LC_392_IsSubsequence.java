package leetCode351_400;

public class LC_392_IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isSubsequence(String s, String t) {
        int spos=0;
        int tpos=0;
        int lens=s.length();
        int lent = t.length();
        while(spos<lens&&tpos<lent) {
        	if(s.charAt(spos)==t.charAt(tpos)) {
        		spos++;tpos++;
        	}else tpos++;
        }
        return spos==lens;
    }
}
