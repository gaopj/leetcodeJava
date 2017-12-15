package LC_301_350;

import java.util.List;

public class LC_345_ReverseVowelsofaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseVowels("aA");
	}
    public static String reverseVowels(String s) {
        if(s==null || s.length()<=1)
            return s;
        int len = s.length();
        char[] res = s.toCharArray();
        int star =0;
        int end = len-1;
        while(star<=end){
            while(star<=end&&(res[star]!='a'&&res[star]!='o'&&res[star]!='e'&&res[star]!='u'&&res[star]!='i'
            		&&res[star]!='A'&&res[star]!='O'&&res[star]!='E'&&res[star]!='U'&&res[star]!='I')){
                star++;
            }
            while(star<=end&&(res[end]!='a'&&res[end]!='o'&&res[end]!='e'&&res[end]!='u'&&res[end]!='i'
            		&&res[end]!='A'&&res[end]!='O'&&res[end]!='E'&&res[end]!='U'&&res[end]!='I')){
                end--;
            }
            if(star<end){
                char temp = res[star];
                res[star] = res[end];
                res[end] = temp;
            }
            star++;
            end--;
        }
        return String.valueOf(res);
    }
}
