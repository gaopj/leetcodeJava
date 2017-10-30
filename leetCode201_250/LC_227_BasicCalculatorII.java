package leetCode201_250;

import java.util.Stack;

public class LC_227_BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = calculate("1 + 1");
	}

    public static int calculate(String s) {
		if(s==null||s.length()==0) return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		char sign ='+';
		int cur =0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				cur = c-'0';
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))) {
					cur = cur*10+s.charAt(++i)-'0';
				}
			}
			
			if(!Character.isDigit(c)&&!Character.isSpaceChar(c)||i==s.length()-1) {
			switch(sign){
				case '+' :
				break;
				case '-' :cur = -cur;
				break;
				case '*':
					cur *=stack.pop();
					break;
				case '/':
					cur=stack.pop()/cur;
					break;
			}
			stack.push(cur);
			cur=0;
			sign = s.charAt(i);
			}
			
		}
		
		for(int i=0;i<stack.size();i++) {
			res+=stack.get(i);
		}
		return res;
    }
}
