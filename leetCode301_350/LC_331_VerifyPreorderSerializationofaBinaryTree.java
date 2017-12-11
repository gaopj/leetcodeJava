package leetCode301_350;

import java.util.Stack;

public class LC_331_VerifyPreorderSerializationofaBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ss = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		isValidSerialization(ss);
	}

    public static boolean isValidSerialization(String preorder) {
        Stack<String> s = new Stack<>();
        String[] pre = preorder.split(",");
        if(pre.length==1)
        	return pre[0].equals("#");
        else if(pre.length==2)
        	return false;
        
        String pre2 =pre[0];
        String pre1 =pre[1];
        s.push(pre2);
        s.push(pre1);
        for(int i=2;i<pre.length;i++) {
        	if(pre[i].equals("#")) {
        		if(pre1.equals("#")&&!pre2.equals("#")&&s.size()>=2) {
        			s.pop();
        			s.pop();
        		}else if (!pre1.equals("#")){
        			;
        		}else {
        			return false;
        		}
        	}
        	if(i<pre.length-1 && s.isEmpty())
        		return false;
        	if(i!=pre.length-1||!s.empty())
        		pre2 = s.peek();
        	s.push(pre[i]);
        	pre1 = s.peek();
        	while(pre1.equals("#")&&pre2.equals("#")&&s.size()>3) {
       			s.pop();
       			s.pop();
       			s.pop();
       			pre2 = s.peek();
       			s.push("#");
       			pre1 = s.peek();
        	}
        	if(pre1.equals("#")&&pre2.equals("#")) {
        		if(i!=pre.length-1)
        			return false;
      			s.pop();
       			s.pop();
       			s.pop();
       			s.push("#");
        	}
        }
        return s.size()==1 &&s.peek().equals("#");
    }
}
