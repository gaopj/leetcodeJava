package leetCode301_350;

import java.util.LinkedList;
import java.util.List;

public class LC_301_RemoveInvalidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<String> res;
	void DFS(String s,char ch,int last) {
		for(int i =0,cnt = 0;i<s.length();i++) {
			char si = s.charAt(i);
			if(si =='('||si==')') cnt+=	si==ch ? 1:-1;
			if(cnt<=0)continue;
			
				for(int j=last;j<=i;j++) {
					if(s.charAt(j)==ch && (j==last|| s.charAt(j-1)!=ch))
						DFS(s.substring(0, j)+s.substring(j+1), ch,j);
				}
			
			return;
		}
		
		String sr= new StringBuilder(s).reverse().toString();
		if(ch==')') {
			DFS(sr, '(',0);
			return ;
		}
		res.add(sr);
	}
    public List<String> removeInvalidParentheses(String s) {
        res =new LinkedList<>();
        DFS( s,')',0);
        return res;
    }

}
