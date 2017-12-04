package leetCode301_350;

public class LC_316_RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++) {
        	count[s.charAt(i)-'a']++;
        }
        int pos=0;
        for(int i=0;i<len;i++) {
        	if(s.charAt(i)<s.charAt(pos))
        		pos=i;
        	if(--count[s.charAt(i)-'a']==0)
        		break;
        }
        return len==0?"":""+s.charAt(pos)+removeDuplicateLetters( s.substring(pos+1).replaceAll(s.charAt(pos)+"", ""));
    }
}
