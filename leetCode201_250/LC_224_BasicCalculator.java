package leetCode201_250;

import java.util.Stack;

public class LC_224_BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calculate(String s) {
		if(s==null||s.length()==0) return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int sign =1;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				int cur = c-'0';
				while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))) {
					cur = cur*10+s.charAt(++i)-'0';
				}
				res += sign*cur;
			}
			switch(c){
				case '-' :sign = -1;
				break;
				case '+' :sign = 1;
				break;
				case '(':
					stack.push(res);
					stack.push(sign);
					res =0;
					sign =1;
					break;
				case ')':
					res = stack.pop()*res +stack.pop();
					sign = 1;
					break;
			}
		}
		return res;
	}
}
