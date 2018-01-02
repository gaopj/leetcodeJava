package leetCode351_400;

import java.util.List;
import java.util.Stack;

public class LC_385_MiniParser {


	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public NestedInteger deserialize(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        if(len==0||arr[0]!='[') { 
        	return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        for(int i=0;i<len;i++) {
        	char ch = arr[i];
        	if(ch=='[')
        		stack.push(new NestedInteger());
        	else if(ch==']' && stack.size()>1) {
        		NestedInteger top = stack.pop();
        		stack.peek().add(top);
        	}else if(Character.isDigit(ch) || ch =='-') {
        		int flag=1;
        		if(ch =='-') {
        			flag=-1;
        			i++;
        		}
        		int num=0;
        			while(i<len &&Character.isDigit(arr[i])) {
        				num *=10;
        				num+=arr[i]-'0';
        				i++;
        			}
        		i--;
        		stack.peek().add(new NestedInteger(num*flag));
        	}

        }
        return stack.pop();
    }

}

