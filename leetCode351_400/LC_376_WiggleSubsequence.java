package LC_351_400;

import java.util.ArrayList;

public class LC_376_WiggleSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int wiggleMaxLength(int[] nums) {
    	ArrayList<Integer> numss = new ArrayList<>();
    	
    	int len = nums.length;
    	if(len<=1)
    		return len;
    	numss.add(nums[0]);
    	for(int i=1;i<len;i++){
    		if(nums[i]!=numss.get(numss.size()-1))
    			numss.add(nums[i]);
    	}
    	len = numss.size();
    	if(len<=2)
    		return len;
        boolean isUP = numss.get(0)>numss.get(1)?false:true;
        int res = 1;
        for(int i=2;i<len;i++){
        	if(numss.get(i)>numss.get(i-1)){
        		if(isUP){
        			continue;
        		}else{
        			res++;
        			isUP=true;
        		}
        		
        	}else if(numss.get(i)<numss.get(i-1)){
        		if(isUP){
        			res++;
        			isUP=false;
        		}else{
        			continue;
        		}
        	}
        	else{
        		continue;
        	}
        }
        return res+1;
    }
}
