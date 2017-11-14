package leetCode251_300;

import java.util.ArrayList;
import java.util.List;

public class LC_282_ExpressionAddOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
    	helper(num,target,"",0,0);
    	return res;
    }
    
    private void helper(String num,int target,String temp,long currRes,long preNum) {
    	if(currRes == target && num.length()==0) {
    		String exp = new String(temp);
    		res.add(exp);
    		return;
    	}
    	
    	for(int i=1;i<=num.length();i++) {
    		String currS = num.substring(0, i);
    		
    		if(currS.length()>1 && currS.charAt(0)=='0') {
    			return;
    		}
    		
    		long currNum = Long.parseLong(currS);
    		String next = num.substring(i);
    		
    		if(temp.length()!=0) {
    			helper(next, target, temp +"*"+currNum, currRes-preNum+preNum*currNum, preNum*currNum);
    			helper(next, target, temp +"+"+currNum, currRes+currNum, currNum);
    			helper(next, target, temp +"-"+currNum, currRes-currNum, -currNum);
    		}else {
    			helper(next, target, currS, currNum, currNum);
    		}
    	}
    }
}
