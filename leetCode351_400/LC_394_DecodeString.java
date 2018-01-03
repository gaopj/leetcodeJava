package leetCode351_400;

public class LC_394_DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int k;
    public String decodeString(String s) {
    	k=0;
    	return dfs(s);
    }

    String dfs(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        int num=0;
       while (k<len) {
        	char ch= s.charAt(k);
        	if(Character.isDigit(ch)) {
        		num  = num*10+(ch-'0');
        		k++;
        	}
        	else if(ch=='[') {
        		k++;
        		String temp = dfs(s);
        		for(int j=0;j<num;j++) {
        			res.append(temp);
        		}
        		num = 0;
        	}
        	else if(ch == ']') {
        		k++;
        		return res.toString();
        	}else {
        		k++;
        		res.append(ch);
        	}
        }
        
        return res.toString();
    }
}
