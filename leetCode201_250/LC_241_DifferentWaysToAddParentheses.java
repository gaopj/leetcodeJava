package leetCode201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_241_DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 private HashMap<String,List<Integer>> hm  =new HashMap<>();
	 public List<Integer> diffWaysToCompute(String input) {
		 if(hm.containsKey(input))
			 return hm.get(input);
	        List<Integer> res = new ArrayList<Integer>();
	        for (int i = 0; i < input.length(); i++) {
	            char ch = input.charAt(i);
	            if (ch == '+' || ch == '-' || ch == '*') {
	                List<Integer> left = diffWaysToCompute(input.substring(0, i));
	                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
	                for (int n : left) {
	                    for (int m : right) {
	                        switch (ch) {
	                        case '+':
	                            res.add(n + m);
	                            break;
	                        case '-':
	                            res.add(n - m);
	                            break;

	                        case '*':
	                            res.add(n * m);
	                            break;
	                        }
	                    }
	                }
	            }
	        }

	        if (res.size() == 0) {
	            res.add(Integer.parseInt(input));
	        }

	        hm.put(input, res);
	        return res;
	    }

}
